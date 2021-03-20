package app.web.pavelk.task2.model.rep;

import app.web.pavelk.task2.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRep extends CrudRepository<User, Long> {
}
