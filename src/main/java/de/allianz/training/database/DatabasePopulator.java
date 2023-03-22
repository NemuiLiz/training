package de.allianz.training.database;

import de.allianz.training.entity.ToDo;
import de.allianz.training.repository.ToDoRepository;
import de.allianz.training.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabasePopulator implements CommandLineRunner{

    //Dependency Injection
    @Autowired      //Object already exists in Spring and we can use it
    private final ToDoRepository toDoRepository;    //needs to be final
    @Autowired
    private final ToDoService toDoService;


    @Override
    public void run(String...args) throws Exception{
        final ToDo toDo1 = new ToDo(null, "Laundry", "60°", "21.03.23", false);
        final ToDo toDo2 = new ToDo(null, "Vacuum cleaning", "Whole appartement", "21.03.23", false);
        final ToDo toDo3 = new ToDo(null, "Clean", "Wet cleaning floor", "21.03.23", true);
        final ToDo toDo4 = new ToDo(null, "Tomatoes", "Plant tomatoes in bigger container", "26.03.23", false);

        toDoService.createToDo(toDo1);
        toDoService.createToDo(toDo2);
        toDoService.createToDo(toDo3);
        toDoService.createToDo(toDo4);

        System.out.println("To Do's " + toDoService.getToDos());
        System.out.println("These to Do's are already done " + toDoService.getToDoByDone(true));
        System.out.println("These are still not done " + toDoService.getToDoByDone(false));

        System.out.println("Delete Laundry");
        toDoService.deleteToDo(toDo1.getId());
        System.out.println("Delete test ");
        System.out.println("To Do's " + toDoService.getToDos());
    }
}
