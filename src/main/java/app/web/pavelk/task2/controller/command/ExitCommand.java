package app.web.pavelk.task2.controller.command;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExitCommand implements Command {

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public List<String> commandName() {
        return Arrays.asList("exit", "-e");
    }
}

