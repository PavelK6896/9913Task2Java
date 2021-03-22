package app.web.pavelk.task2.controller;

import app.web.pavelk.task2.controller.command.Command;
import app.web.pavelk.task2.controller.command.HelpCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class ConsoleController implements CommandLineRunner {

    @Autowired
    @Qualifier("commandMap")
    private Map<String, Command> commandMap;
    private final HelpCommand helpCommand;
    private final Scanner scanner;

    @Override
    public void run(String... args) throws InterruptedException {
        do {
            TimeUnit.MILLISECONDS.sleep(500);
        } while (commandMap.getOrDefault(scanner.next(), helpCommand).execute());
    }


}


