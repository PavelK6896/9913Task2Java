package app.web.pavelk.task2.model.rep;

import app.web.pavelk.task2.model.Task;
import app.web.pavelk.task2.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TaskRep extends CrudRepository<Task, Long> {

    @Query("select sum (t.time) from Task as t where t.user = :user ")
    Integer findAllTimeByUser(User user);

}
