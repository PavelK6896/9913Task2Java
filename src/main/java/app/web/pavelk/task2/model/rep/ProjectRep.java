package app.web.pavelk.task2.model.rep;

import app.web.pavelk.task2.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRep extends CrudRepository<Project, Long> {
}
