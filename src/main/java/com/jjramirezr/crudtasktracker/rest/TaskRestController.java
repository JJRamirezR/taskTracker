package com.jjramirezr.crudtasktracker.rest;


import com.jjramirezr.crudtasktracker.entity.Task;
import com.jjramirezr.crudtasktracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private TaskService taskService;


    @Autowired
    public TaskRestController(TaskService theTaskService){
        taskService = theTaskService;
    }


    @GetMapping("/tasks")
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable int taskId){

        Task theTask = taskService.findById(taskId);
        if (theTask == null){
            throw new RuntimeException("Id de Tarea no encontrada - " + taskId );
        }

        return theTask;
    }

    @PostMapping("/tasks")
    public Task addTask (@RequestBody Task theTask){
        theTask.setId(0);

        Task dbTask = taskService.save(theTask);
        return dbTask;
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task theTask){

        Task dbTask = taskService.save(theTask);

        return dbTask;
    }

    @DeleteMapping("/tasks/{taskId")
    public String deleteTask (@PathVariable int taskId){
        Task tempTask = taskService.findById(taskId);

        if(tempTask == null){
            throw new RuntimeException("Tarea no encontrada - " + taskId );
        }

        taskService.deleteById(taskId);
        return "Tarea elmininada correctamente ID - " + taskId;
    }

}
