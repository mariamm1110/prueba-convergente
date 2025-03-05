package com.convergente.pruebaconvergente.repositories;

import com.convergente.pruebaconvergente.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, String> {

    List<Task> findByUserId(String userId);
}
