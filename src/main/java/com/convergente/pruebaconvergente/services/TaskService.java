package com.convergente.pruebaconvergente.services;

import com.convergente.pruebaconvergente.dtos.TaskDTO;
import com.convergente.pruebaconvergente.models.Task;
import com.convergente.pruebaconvergente.models.User;
import com.convergente.pruebaconvergente.repositories.ITaskRepository;
import com.convergente.pruebaconvergente.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepository taskRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<Task> getTaskByUser(String userId) {
        return this.taskRepository.findByUserId(userId);
    }

    @Override
    public Task createTask(TaskDTO taskDto) {
        Optional<User> userOptional = this.userRepository.findById(taskDto.userId());
        if (userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }

        Task task = new Task();
        task.setTitle(taskDto.title());
        task.setDescription(taskDto.description());
        task.setState(taskDto.state());
        task.setUser(userOptional.get());

        return this.taskRepository.save(task);
    }

    @Override
    public Task updateTask(String taskId, TaskDTO taskDto) {
        Task task = this.taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskDto.title());
        task.setDescription(taskDto.description());
        task.setState(taskDto.state());

        return this.taskRepository.save(task);
    }

    @Override
    public void deleteTask(String taskId) {
        if(!this.taskRepository.existsById(taskId)) {
            throw new RuntimeException("Task not found");
        }
        this.taskRepository.deleteById(taskId);

    }
}
