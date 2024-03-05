package org.list4team.services;

import org.list4team.model.entities.User;
import org.list4team.repositories.UserRepository;
import org.list4team.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();

    }
}
