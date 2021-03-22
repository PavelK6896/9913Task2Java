package app.web.pavelk.task2.service.command;

import app.web.pavelk.task2.model.User;
import app.web.pavelk.task2.model.rep.UserRep;
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
public class UserCommand implements Crud {

    private final UserRep userRep;
    private final Scanner scanner;
    private final ObjectMapper objectMapper;

    @Override
    public void get() throws JsonProcessingException {
        log.info(objectMapper.writeValueAsString(userRep.findAll()));
    }

    @Override
    public void create() {
        log.info("create user enter a name");
        userRep.save(User.builder().firstName(scanner.next()).build());
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Integer id() {
        return 3;
    }
}
