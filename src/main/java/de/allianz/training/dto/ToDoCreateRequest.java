package de.allianz.training.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString

@NoArgsConstructor
public class ToDoCreateRequest {


    @NotBlank(message = "Title is mandatory")
    private String title;


}
