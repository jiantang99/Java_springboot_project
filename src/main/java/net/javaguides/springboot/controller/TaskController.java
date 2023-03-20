package net.javaguides.springboot.controller;

import net.javaguides.springboot.service.TaskService;
import net.javaguides.springboot.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    @ResponseBody
    public List<TaskDTO> getAllTasks(){
        return taskService.getAllTasks();
    }

}
