package de.allianz.training.repository;

import de.allianz.training.entity.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    List<ToDo> findAllByDone(Boolean done);
    Long countAllByDone(Boolean done);
}
