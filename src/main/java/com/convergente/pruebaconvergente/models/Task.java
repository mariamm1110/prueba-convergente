package com.convergente.pruebaconvergente.models;


import com.convergente.pruebaconvergente.utils.TaskState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    
    
    private String id;

    
    
    private String title;

    
    
    private String description;

    
    
    @Enumerated(EnumType.STRING)
    private TaskState state;

    
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;


}
