package net.javaguides.springboot.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private long Id;
    private String title;
    private String description;
    private Boolean completed;
}
