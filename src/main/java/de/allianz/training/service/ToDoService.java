package de.allianz.training.service;

import de.allianz.training.entity.ToDo;
import de.allianz.training.repository.ToDoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;

    //Create To Do
    public void createToDo(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    //Update To Do
    //Gets ToDo to update by ID then overwrites every Column with new values
    public void updateToDo(ToDo toDo) {
        ToDo updateToDo = toDoRepository.findById(toDo.getId()).orElseThrow(
                () -> new EntityNotFoundException("To Do not found."));
        updateToDo.setDone(toDo.getDone());
        updateToDo.setText(toDo.getText());
        updateToDo.setTitle(toDo.getTitle());
        updateToDo.setDueDate(toDo.getDueDate());

        this.toDoRepository.save(updateToDo);
    }

    //Delete existing To Do
    public void deleteToDo(Long id) {
        this.toDoRepository.deleteById(id);
    }

    //Get all the To Do's
    public List<ToDo> getToDos(ToDo toDo) {
        return (List<ToDo>) this.toDoRepository.findAll();
    }

    //Get the finished To Do's
    public List<ToDo> getToDoByDone(Boolean done) {
        return this.toDoRepository.findAllByDone(done);
    }

    public Long getDoneCount(Boolean done) {
        return this.toDoRepository.countAllByDone(done);
    }
}
