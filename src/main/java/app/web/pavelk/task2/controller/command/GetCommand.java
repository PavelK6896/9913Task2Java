package app.web.pavelk.task2.controller.command;


import app.web.pavelk.task2.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetCommand implements Command {

    private final MainService mainService;
    private final Scanner scanner;

    @Override
    public boolean execute() {

        log.info("\n1 - getUserByTask\n2 - getListProject\n3 - ");
        int id = Integer.parseInt(scanner.next());
        if (id == 1) {
            mainService.getUserByTask();
        } else if (id == 2) {
            mainService.getListProject();
        }

        return true;
    }

    @Override
    public List<String> commandName() {
        return Arrays.asList("get", "-g");
    }

}

