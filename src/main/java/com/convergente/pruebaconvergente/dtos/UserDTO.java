package com.convergente.pruebaconvergente.dtos;

import java.util.List;
public record UserDTO(
        String id,
        String name,
        String email,
        List<TaskDTO> tasks
) { }
