package app.web.pavelk.task2.service;

import app.web.pavelk.task2.model.Project;
import app.web.pavelk.task2.model.Task;
import app.web.pavelk.task2.model.User;
import app.web.pavelk.task2.model.init.LoadJson;
import app.web.pavelk.task2.model.init.UploadFile;
import app.web.pavelk.task2.model.rep.ProjectRep;
import app.web.pavelk.task2.model.rep.TaskRep;
import app.web.pavelk.task2.model.rep.UserRep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {

    private final ProjectRep projectRep;
    private final TaskRep taskRep;
    private final UserRep userRep;

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


//    public void getListProject() { //один запрос
//        projectRep.findAll().forEach(f -> {
//            System.out.println(f.getProjectId());
//            System.out.println(f.getProjectName());
//        });
//    }


}
