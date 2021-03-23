package app.web.pavelk.task2.service.command;

import app.web.pavelk.task2.model.Project;
import app.web.pavelk.task2.model.rep.ProjectRep;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Scanner;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProjectCommand implements Crud {

    private final ProjectRep projectRep;
    private final Scanner scanner;
    private final ObjectMapper objectMapper;

    @Override
    public void get() {
        try {
            log.info("\n" + objectMapper.writeValueAsString(projectRep.findAll()));
        } catch (JsonProcessingException e) {
            log.error("get ", e);
        }
    }

    @Override
    public void create() {
        log.info("\ncreate project enter a name");
        projectRep.save(Project.builder().projectName(scanner.next()).build());
        this.get();
    }


    @Override
    public void update() {
        this.get();
        Project project = new Project();
        log.info("\nid ");
        project.setProjectId(Long.parseLong(scanner.next()));
        log.info("\nname ");
        project.setProjectName(scanner.next());
        projectRep.save(project);
        this.get();
    }

    @Override
    public void delete() {
        this.get();
        log.info("\nid ");
        projectRep.deleteById(Long.parseLong(scanner.next()));
        this.get();
    }

    @Override
    public Integer id() {
        return 1;
    }
}
