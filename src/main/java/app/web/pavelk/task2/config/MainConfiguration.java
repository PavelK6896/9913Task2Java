package app.web.pavelk.task2.config;

import app.web.pavelk.task2.controller.command.Command;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
public class MainConfiguration {

    @Bean
    public Map<String, Command> commandMap(List<Command> commandList) {
        Map<String, Command> map = new HashMap<>();
        commandList.forEach(f -> f.commandName().forEach(n -> map.put(n, f)));
        return map;
    }

}
