package de.allianz.training.controller;

import de.allianz.training.dto.ToDoCreateRequest;
import de.allianz.training.dto.ToDoUpdateRequest;
import de.allianz.training.entity.ToDo;
import de.allianz.training.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//Communicates with Service
@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class ToDoController {


    private final ToDoService toDoService;
    private final ModelMapper modelMapper;

    /**
     *
     * @return List of all to do
     */
    @GetMapping
    public List<ToDo> getToDo() {
        return this.toDoService.getToDos();
    }

    /**
     *
     * @return all to do depending on true or false
     */
    @GetMapping("/done")
    public List<ToDo> getToDoByDone() {
        return this.toDoService.getToDoByDone(true);
    }

    /**
     *
     *
     * @return the count of done to do depending on true or false
     */
    @GetMapping("/done/count")
    public Long getDoneCount() {
        return this.toDoService.getDoneCount(true);
    }

    @GetMapping("/{id}")
    public ToDo getIdToDo(@PathVariable("id") Long id) {
        return this.toDoService.getId(id);
    }
    /**
     *
     * @param toDoCreateRequest
     * creates a new to do
     */
    @PostMapping
    public ToDo create(@Valid @RequestBody ToDoCreateRequest toDoCreateRequest) {
        return this.toDoService.createToDo(modelMapper.map(toDoCreateRequest, ToDo.class));
    }

    /**
     *
     * @param toDoUpdateRequest
     * gets the ToDo by id
     * throws Exception if id is not found
     * overwrites variables with new arguments and saves them
     */
    @PutMapping
    public ToDo updateToDo(@Valid @RequestBody ToDoUpdateRequest toDoUpdateRequest) {
        ToDo toDo = this.toDoService.getId(toDoUpdateRequest.getId());
        modelMapper.map(toDoUpdateRequest, toDo);

        return this.toDoService.updateToDo(toDo);
    }

    /**
     *
     * @param id
     * gets id of To Do and deletes the To Do
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable("id") Long id) {
        this.toDoService.deleteToDo(id);
        return new ResponseEntity<>((HttpStatus.NO_CONTENT));
    }
}
