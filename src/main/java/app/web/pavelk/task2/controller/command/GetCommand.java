package app.web.pavelk.task2.controller.command;


import app.web.pavelk.task2.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCommand implements Command {

    private final MainService mainService;

    @Override
    public boolean execute() {
        mainService.getListProject();

        return true;
    }


    @Override
    public List<String> commandName() {
        return Arrays.asList("get", "-g");
    }

}

