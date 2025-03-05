
package com.convergente.pruebaconvergente.dtos;

import com.convergente.pruebaconvergente.utils.TaskState;

public record TaskDTO(
        String id,
        String title,
        String description,
        TaskState state,

        String userId
) {}
