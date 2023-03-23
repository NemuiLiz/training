package de.allianz.training.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@ToString

@NoArgsConstructor
public class ToDoCreateRequest {


    @NotBlank(message = "Title is mandatory")
    private String title;


}
