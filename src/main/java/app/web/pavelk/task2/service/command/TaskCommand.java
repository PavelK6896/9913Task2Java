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
    public void get() {
        try {
            log.info("\n" + objectMapper.writeValueAsString(taskRep.findAll()));
        } catch (JsonProcessingException e) {
            log.error("get ", e);
        }
    }

    @Override
    public void create() {
        log.info("\ncreate task enter a name");
        taskRep.save(Task.builder().taskName(scanner.next()).build());
        this.get();
    }

    @Override
    public void update() {
        this.get();
        Task task = new Task();
        log.info("\nid ");
        task.setTaskId(Long.parseLong(scanner.next()));
        log.info("\nname ");
        task.setTaskName(scanner.next());
        taskRep.save(task);
        this.get();
    }

    @Override
    public void delete() {
        this.get();
        log.info("\nid ");
        taskRep.deleteById(Long.parseLong(scanner.next()));
        this.get();
    }

    @Override
    public Integer id() {
        return 3;
    }
}
