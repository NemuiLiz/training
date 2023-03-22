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

    /**
     *
     * @param toDo
     * creates a new to do
     */
    public void createToDo(ToDo toDo) {
        toDoRepository.save(toDo);
    }

    /**
     *
     * @param toDo
     * gets the ToDo by id
     * throws Exception if id is not found
     * overwrites variables with new arguments and saves them
     */
    public void updateToDo(ToDo toDo) {
        ToDo updateToDo = toDoRepository.findById(toDo.getId()).orElseThrow(
                () -> new EntityNotFoundException("To Do not found."));
        updateToDo.setDone(toDo.getDone());
        updateToDo.setText(toDo.getText());
        updateToDo.setTitle(toDo.getTitle());
        updateToDo.setDueDate(toDo.getDueDate());

        this.toDoRepository.save(updateToDo);
    }

    /**
     *
     * @param id
     * gets id of To Do and deletes the To Do
     */
    public void deleteToDo(Long id) {
        this.toDoRepository.deleteById(id);
    }

    /**
     *
     * @return all toDos
     */
    public List<ToDo> getToDos() {
        return (List<ToDo>) this.toDoRepository.findAll();
    }

    /**
     *
     * @param done
     * @return all to do's depending on true or false
     */
    public List<ToDo> getToDoByDone(Boolean done) {
        return this.toDoRepository.findAllByDone(done);
    }

    /**
     *
     * @param done
     * @return the count of done to do's depending on true or false
     */
    public Long getDoneCount(Boolean done) {
        return this.toDoRepository.countAllByDone(done);
    }
}
