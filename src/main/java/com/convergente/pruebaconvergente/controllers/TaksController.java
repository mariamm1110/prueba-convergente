package com.convergente.pruebaconvergente.controllers;

import com.convergente.pruebaconvergente.dtos.TaskDTO;
import com.convergente.pruebaconvergente.models.Task;
import com.convergente.pruebaconvergente.services.ITaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:9000")
public class TaksController {

    @Autowired
    private ITaskService taskService;

    @GetMapping("/{userId}")
    public List<Task> getTasksByUser(@PathVariable String userId) {
        return this.taskService.getTaskByUser(userId);
    }

    @PostMapping("/newtask")
    public ResponseEntity<?> createTask(@Valid @RequestBody TaskDTO taskDTO,
                                           BindingResult result) {
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        Task createdTask = this.taskService.createTask(taskDTO);
        return ResponseEntity.ok(createdTask);
    }

    @DeleteMapping("/deletetask/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
        this.taskService.deleteTask(taskId);
    }

    @PutMapping("/updatetask/{taskId}")
    public ResponseEntity<?> updateTask(@Valid  @RequestBody TaskDTO taskDTO,
                                           @PathVariable String taskId, BindingResult result) {
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        Task updatedTask = this.taskService.updateTask(taskId, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }
}
