package app.web.pavelk.task2.service;

import app.web.pavelk.task2.model.Project;
import app.web.pavelk.task2.model.Task;
import app.web.pavelk.task2.model.User;
import app.web.pavelk.task2.model.init.LoadJson;
import app.web.pavelk.task2.model.init.UploadFile;
import app.web.pavelk.task2.model.rep.ProjectRep;
import app.web.pavelk.task2.model.rep.TaskRep;
import app.web.pavelk.task2.model.rep.UserRep;
import app.web.pavelk.task2.service.command.ProjectCommand;
import app.web.pavelk.task2.service.command.TaskCommand;
import app.web.pavelk.task2.service.command.UserCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {

    private final Scanner scanner;
    private final ProjectRep projectRep;
    private final TaskRep taskRep;
    private final UserRep userRep;
    private final ProjectCommand projectCommand;
    private final UserCommand userCommand;
    private final TaskCommand taskCommand;

    @PostConstruct
    @Transactional
    public void loadInit() throws IOException {
        LoadJson loadJson = UploadFile.getFile();
        for (Project p : loadJson.getProjects()) {
            projectRep.save(p);
        }
        for (User p : loadJson.getUsers()) {
            userRep.save(p);
        }
        for (Task p : loadJson.getTasks()) {
            taskRep.save(p);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
    public void getListProject() {
        projectRep.findAll().forEach(f -> {
            System.out.println(f);
            System.out.println(f.getListUser().size());
        });
    }

    @Transactional
    public void setUserToProject() {
        projectCommand.get();
        log.info("\nselect project id ");
        Project project = projectRep.findById(Long.parseLong(scanner.next())).orElseThrow(EntityNotFoundException::new);
        userCommand.get();
        log.info("\nselect user id ");
        User user = userRep.findById(Long.parseLong(scanner.next())).orElseThrow(EntityNotFoundException::new);
        project.getListUser().add(user);
        projectRep.save(project);
        projectCommand.get();
    }


    @Transactional
    public void setTaskToUser() {
        userCommand.get();
        log.info("\nselect user id ");
        User user = userRep.findById(Long.parseLong(scanner.next())).orElseThrow(EntityNotFoundException::new);
        taskCommand.get();
        log.info("\nselect task id ");
        Task task = taskRep.findById(Long.parseLong(scanner.next())).orElseThrow(EntityNotFoundException::new);
        user.getListTasks().add(task);
        task.setUser(user);
        userRep.save(user);
        taskRep.save(task);
        userCommand.get();
    }


    @Transactional
    public void getUserByTask() {
        taskCommand.get();
        log.info("\nselect task id ");
        Task task = taskRep.findById(Long.parseLong(scanner.next())).orElseThrow(EntityNotFoundException::new);
        System.out.println(task.getUser());
    }


}
