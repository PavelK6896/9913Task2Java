package app.web.pavelk.task2.controller.command;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HelpCommand implements Command {

    private final List<Command> list;

    @Override
    public boolean execute() {
        list.forEach(c -> {
            System.out.println(c.commandName());
        });
        System.out.println(commandName());
        return true;
    }

    @Override
    public List<String> commandName() {
        return Arrays.asList("help", "-h");
    }

}

