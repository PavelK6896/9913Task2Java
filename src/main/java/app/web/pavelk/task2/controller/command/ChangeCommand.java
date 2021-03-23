package app.web.pavelk.task2.controller.command;


import app.web.pavelk.task2.service.command.Crud;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChangeCommand implements Command {

    private final Scanner scanner;

    @Autowired
    @Qualifier("crudMap")
    private Map<Integer, Crud> crudMap;

    @Override
    public boolean execute() {
        log.info("\n1 - Project\n2 - User\n3 - Task");
        int id = Integer.parseInt(scanner.next());
        Crud crud = crudMap.get(id);
        log.info("\n1 - get\n2 - create\n3 - update\n4 - delete");
        id = Integer.parseInt(scanner.next());
        if (id == 1) {
            crud.get();
        } else if (id == 2) {
            crud.create();
        } else if (id == 3) {
            crud.update();
        } else if (id == 4) {
            crud.delete();
        }
        return true;
    }

    @Override
    public List<String> commandName() {
        return Arrays.asList("change", "-c");
    }

}

