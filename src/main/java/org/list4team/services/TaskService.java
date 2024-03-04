package org.list4team.services;

import org.list4team.model.entities.Task;
import org.list4team.model.entities.User;
import org.list4team.repositories.TaskRepository;
import org.list4team.repositories.UserRepository;
import org.list4team.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;
    public List<Task> findAll(){
        return repository.findAll();

    }
    public Task findById(int id){
        Optional<Task> task = repository.findById(id);
        return task.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
