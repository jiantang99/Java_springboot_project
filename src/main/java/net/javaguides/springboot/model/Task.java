package net.javaguides.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    private Boolean completed;
}
