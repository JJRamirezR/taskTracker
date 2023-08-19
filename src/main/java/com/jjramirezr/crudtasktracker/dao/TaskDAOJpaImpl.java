package com.jjramirezr.crudtasktracker.dao;

import com.jjramirezr.crudtasktracker.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOJpaImpl implements TaskDAO{

    private EntityManager entityManager;


    @Autowired
    public TaskDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Task> findAll() {

        TypedQuery<Task> theQuery = entityManager.createQuery("from Task", Task.class);


        List<Task> tasks = theQuery.getResultList();


        return tasks;

    }

    @Override
    public Task findById(int theId) {

        Task theTask = entityManager.find(Task.class, theId);

        return theTask;
    }

    @Override
    public Task save(Task theTask) {

        Task dbTask = entityManager.merge(theTask);

        return dbTask;
    }

    @Override
    public void deleteById(int theId) {

        Task theTask = entityManager.find(Task.class, theId);

        entityManager.remove(theTask);

    }
}
