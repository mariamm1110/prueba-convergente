package com.convergente.pruebaconvergente.dtos;

import com.convergente.pruebaconvergente.models.Task;
import com.convergente.pruebaconvergente.models.User;

import java.util.stream.Collectors;

public class DTOMapper {

    public static UserDTO toUserDTO (User user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getTasks().stream().map(DTOMapper::toTaskDTO).collect(Collectors.toList())
        );
    }

    public static  TaskDTO toTaskDTO(Task task){
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getState(),
                task.getUser().getId()
        );
    }
}
