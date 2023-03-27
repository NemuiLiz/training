package de.allianz.training.repository;

import de.allianz.training.controller.ToDoController;
import de.allianz.training.entity.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ToDoRepositoryTest {

    @Autowired
    private ToDoRepository toDoRepository;
    ToDo toDo1;
    ToDo toDo2;
    ToDo toDo3;
    ToDo toDo4;

    @BeforeEach
    public void init() {
        toDo1 = new ToDo(null, "Laundry", "60°", "21.03.23", false);
        toDo2 = new ToDo(null, "Vacuum cleaning", "Whole appartement", "21.03.23", false);
        toDo3 = new ToDo(null, "Clean", "Wet cleaning floor", "21.03.23", true);
        toDo4 = new ToDo(null, "Tomatoes", "Plant tomatoes in bigger container", "26.03.23", false);

        toDoRepository.save(toDo1);
        toDoRepository.save(toDo2);
        toDoRepository.save(toDo3);
        toDoRepository.save(toDo4);
    }

    @Test
    void findAllByDone() {
        assertTrue(toDoRepository.findAllByDone(true).contains(toDo3));
        assertFalse(toDoRepository.findAllByDone(true).contains(toDo1));
    }

    @Test
    void countAllByDone() {
        assertEquals(1, toDoRepository.countAllByDone(true));
        assertEquals(3, toDoRepository.countAllByDone(false));
    }
}