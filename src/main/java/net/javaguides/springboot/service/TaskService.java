package net.javaguides.springboot.service;

import net.javaguides.springboot.repository.TaskRepository;
import net.javaguides.springboot.dto.TaskDTO;
import net.javaguides.springboot.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import java.util.Optional;



import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAllTasks(){
        return ((List<Task>) taskRepository
                .findAll())
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

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(long id, Task taskRequest) throws ResourceNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task updated"));

        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setCompleted(taskRequest.getCompleted());
        return taskRepository.save(task);
    }

    public void deleteTask(long id) throws ResourceNotFoundException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task deleted"));

        taskRepository.delete(task);
    }

    public Task getTaskById(long id) throws ResourceNotFoundException {
        Optional<Task> result = taskRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Id not found");
        }
    }
}
