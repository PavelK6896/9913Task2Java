package app.web.pavelk.task2.service.command;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Crud {
    void get() throws JsonProcessingException;

    void create();

    void update();

    void delete();

    Integer id();
}
