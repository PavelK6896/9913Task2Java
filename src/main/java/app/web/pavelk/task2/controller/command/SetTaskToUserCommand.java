package app.web.pavelk.task2.controller.command;


import app.web.pavelk.task2.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SetTaskToUserCommand implements Command {

    private final MainService mainService;

    @Override
    public boolean execute() {
        mainService.setTaskToUser();
        return true;
    }

    @Override
    public List<String> commandName() {
        return Arrays.asList("set task to user", "-tu");
    }

}

