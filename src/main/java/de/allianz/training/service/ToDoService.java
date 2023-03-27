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
    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    /**
     * Update To Do
     * @param toDo
     * gets the ToDo by id
     * throws Exception if id is not found
     * overwrites variables with new arguments and saves them
     */
    public ToDo updateToDo(ToDo toDo) {
        ToDo updateToDo = toDoRepository.findById(toDo.getId()).orElseThrow(
                () -> new EntityNotFoundException("To Do not found."));
        updateToDo.setDone(toDo.getDone());
        updateToDo.setText(toDo.getText());
        updateToDo.setTitle(toDo.getTitle());
        updateToDo.setDueDate(toDo.getDueDate());

        this.toDoRepository.save(updateToDo);
        return updateToDo;
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
     * @return all to do depending on true or false
     */
    public List<ToDo> getToDoByDone(Boolean done) {
        return this.toDoRepository.findAllByDone(done);
    }

    /**
     *
     * @param done
     * @return the count of done to do depending on true or false
     */
    public Long getDoneCount(Boolean done) {
        return this.toDoRepository.countAllByDone(done);
    }

    public ToDo getId(Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not Found"));
    }

}
