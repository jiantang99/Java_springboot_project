package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Task;
import net.javaguides.springboot.service.TaskService;
import net.javaguides.springboot.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import net.javaguides.springboot.payload.ApiResponse;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    private ModelMapper modelMapper = new ModelMapper();
    public TaskController(TaskService taskService){
        super();
        this.taskService = taskService;
    }

    @GetMapping
    //@ResponseBody
    public List<TaskDTO> getAllTasks(){
        return taskService.getAllTasks().stream().map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        Task task = taskService.getTaskById(id);

        // convert entity to DTO
        TaskDTO taskResponse = modelMapper.map(task, TaskDTO.class);

        return ResponseEntity.ok().body(taskResponse);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDto) {

        // convert DTO to entity
        Task taskRequest = modelMapper.map(taskDto, Task.class);

        Task task = taskService.createTask(taskRequest);

        // convert entity to DTO
        TaskDTO postResponse = modelMapper.map(task, TaskDTO.class);

        return new ResponseEntity<TaskDTO>(postResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = {"*/*"})
    public ResponseEntity<TaskDTO> updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO) throws ResourceNotFoundException {

        // convert DTO to Entity
        Task taskRequest = modelMapper.map(taskDTO, Task.class);

        Task task = taskService.updateTask(id, taskRequest);

        // entity to DTO
        TaskDTO taskResponse = modelMapper.map(task, TaskDTO.class);

        return ResponseEntity.ok().body(taskResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTask(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        taskService.deleteTask(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Task deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

}
