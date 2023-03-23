package de.allianz.training.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@ToString

@NoArgsConstructor
public class ToDoUpdateRequest {

    @NotNull
    private String title;

    @NotNull
    private Boolean done;

    private Long id;
}
