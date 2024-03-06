package org.list4team.services;

import org.list4team.model.entities.Task;
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

    public User findById(int id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insertUser(User user){
        return repository.save(user);
    }

    public void deleteUser(int id){
        repository.deleteById(id);
    }

    public User updateUser(int id, User user){
        User entity = repository.getOne(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user){
        entity.setNome(user.getNome());
        entity.setEmail(user.getEmail());
        entity.setEmail(user.getEmail());
        entity.setCargo(user.getCargo());
        entity.setTokem(user.getTokem());
    }
}
