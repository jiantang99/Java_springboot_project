package net.javaguides.springboot.service;

import net.javaguides.springboot.repository.TaskRepository;
import net.javaguides.springboot.dto.TaskDTO;
import net.javaguides.springboot.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAllId(){
        return taskRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    private TaskDTO convertEntityToDto(Task task){
        TaskDTO taskDto = new TaskDTO();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setTitle(task.getTitle());
        taskDto.setCompleted(task.getCompleted());
        return taskDto;
    }
}
