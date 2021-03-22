package app.web.pavelk.task2.config;

import app.web.pavelk.task2.controller.command.Command;
import app.web.pavelk.task2.service.command.Crud;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;


@Configuration
public class MainConfiguration {

    @Bean
    public Map<String, Command> commandMap(List<Command> commandList) {
        Map<String, Command> map = new HashMap<>();
        commandList.forEach(f -> f.commandName().forEach(n -> map.put(n, f)));
        return map;
    }

    @Bean
    public Map<Integer, Crud> crudMap(List<Crud> list) {
        return list.stream().collect(toMap(Crud::id, Function.identity()));
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }


    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return objectMapper;
    }

}
