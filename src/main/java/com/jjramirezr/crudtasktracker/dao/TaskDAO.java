package com.jjramirezr.crudtasktracker.dao;

import com.jjramirezr.crudtasktracker.entity.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> findAll();

    Task findById(int theId);

    Task save(Task theTask);

    void deleteById(int theId);

}
