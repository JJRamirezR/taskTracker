package com.jjramirezr.crudtasktracker.service;

import com.jjramirezr.crudtasktracker.dao.TaskDAO;
import com.jjramirezr.crudtasktracker.entity.Task;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl (TaskDAO theTaskDAO){
        taskDAO = theTaskDAO;
    }
    @Override
    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    @Override
    public Task findById(int theId) {
        return taskDAO.findById(theId);
    }

    @Transactional
    @Override
    public Task save(Task theTask) {
        return taskDAO.save(theTask);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        taskDAO.deleteById(theId);
    }
}
