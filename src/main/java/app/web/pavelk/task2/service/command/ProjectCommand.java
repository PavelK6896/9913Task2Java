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
    public void get() throws JsonProcessingException {
        log.info(objectMapper.writeValueAsString(projectRep.findAll()));

    }

    @Override
    public void create() {
        log.info("create project enter a name");
        projectRep.save(Project.builder().projectName(scanner.next()).build());
    }


    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Integer id() {
        return 1;
    }
}
