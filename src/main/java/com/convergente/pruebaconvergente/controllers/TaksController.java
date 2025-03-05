package com.convergente.pruebaconvergente.controllers;

import com.convergente.pruebaconvergente.dtos.TaskDTO;
import com.convergente.pruebaconvergente.models.Task;
import com.convergente.pruebaconvergente.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaksController {

    @Autowired
    private ITaskService taskService;

    @GetMapping("/{userId}")
    public List<Task> getTasksByUser(@PathVariable String userId) {
        return this.taskService.getTaskByUser(userId);
    }

    @PostMapping("/newtask")
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO) {
        Task createdTask = this.taskService.createTask(taskDTO);
        return ResponseEntity.ok(createdTask);
    }

    @DeleteMapping("/deletetask/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
        this.taskService.deleteTask(taskId);
    }

    @PutMapping("/updatetask/{taskId}")
    public ResponseEntity<Task> updateTask(@RequestBody TaskDTO taskDTO, @PathVariable String taskId) {
        Task updatedTask = this.taskService.updateTask(taskId, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }
}
