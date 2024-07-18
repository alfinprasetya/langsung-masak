package com.enigma.food.utils.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeCreatesUpdatesDTO {
    @NotBlank
    @Size(max = 110, min =2)
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String method;

    @NotNull
    @Positive
    @Size(max = 15)
    private String price;
}