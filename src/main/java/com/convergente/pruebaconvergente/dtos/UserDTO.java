package com.convergente.pruebaconvergente.dtos;

import jakarta.validation.constraints.*;

import java.util.List;
public record UserDTO(

        String id,
        @NotBlank(message = "Must add a name")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 chars")
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Name can only contain letters and spaces")
        String name,

        @NotBlank
        @Email(message = "Invalid email format")
        String email,


        List<TaskDTO> tasks
) { }
