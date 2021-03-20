package app.web.pavelk.task2.model.rep;

import app.web.pavelk.task2.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRep extends CrudRepository<Task, Long> {
}
