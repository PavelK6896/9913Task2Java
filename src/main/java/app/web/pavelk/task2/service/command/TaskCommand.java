package app.web.pavelk.task2.service.command;

import app.web.pavelk.task2.model.Task;
import app.web.pavelk.task2.model.rep.TaskRep;
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
public class TaskCommand implements Crud {
    private final TaskRep taskRep;
    private final Scanner scanner;
    private final ObjectMapper objectMapper;


    @Override
    public void get() throws JsonProcessingException {
        log.info(objectMapper.writeValueAsString(taskRep.findAll()));

    }

    @Override
    public void create() {
        log.info("create task enter a name");
        taskRep.save(Task.builder().taskName(scanner.next()).build());
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Integer id() {
        return 2;
    }
}
