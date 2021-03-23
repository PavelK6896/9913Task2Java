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
    public void get() {
        try {
            log.info("\n" + objectMapper.writeValueAsString(userRep.findAll()));
        } catch (JsonProcessingException e) {
            log.error("get ", e);
        }
    }

    @Override
    public void create() {
        log.info("\ncreate user enter a name");
        userRep.save(User.builder().firstName(scanner.next()).build());
        this.get();
    }

    @Override
    public void update() {
        this.get();
        User user = new User();
        log.info("\nid ");
        user.setUserId(Long.parseLong(scanner.next()));
        log.info("\nname ");
        user.setFirstName(scanner.next());
        userRep.save(user);
        this.get();
    }

    @Override
    public void delete() {
        this.get();
        log.info("\nid ");
        userRep.deleteById(Long.parseLong(scanner.next()));
        this.get();
    }

    @Override
    public Integer id() {
        return 2;
    }
}
