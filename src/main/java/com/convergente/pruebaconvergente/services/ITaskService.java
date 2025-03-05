package com.convergente.pruebaconvergente.services;

import com.convergente.pruebaconvergente.dtos.TaskDTO;
import com.convergente.pruebaconvergente.models.Task;

import java.util.List;

public interface ITaskService {

    List<Task> getTaskByUser(String userId);
    Task createTask(TaskDTO taskDto);
    Task updateTask(String taskId, TaskDTO taskDto);
    void deleteTask(String taskId);
}
