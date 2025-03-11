
package com.convergente.pruebaconvergente.dtos;
import jakarta.validation.constraints.NotBlank;

import com.convergente.pruebaconvergente.utils.TaskState;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskDTO(
        String id,

        @NotBlank(message = "Must add a title to this task")
        @Size(min = 3, max = 100, message = "Title must be between 3 and 100 chars")
        String title,
        @Size(max = 500, message = "Description cannot exceed 500 chars")
        String description,

        @NotNull(message = "State cannot be null")
        TaskState state,
        @NotBlank(message = "UserId missing for this task")
        String userId
) {}
