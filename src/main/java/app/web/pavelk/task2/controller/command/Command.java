package app.web.pavelk.task2.controller.command;

import java.util.List;

public interface Command {

    boolean execute();

    List<String> commandName();


}
