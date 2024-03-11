package org.list4team.controllers;

import org.list4team.model.entities.Task;
import org.list4team.model.entities.User;
import org.list4team.services.TaskService;
import org.list4team.services.UserService;
import org.list4team.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        List<Task> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/adduser")
    public ResponseEntity<Task> addUserToTask(@RequestParam("taskid") int taskid, @RequestParam("userid") int userid){
        try{
            Task task = service.findById(taskid);
            User user = userService.findById(userid);
            if (task != null && user != null){
                task.addWorkers(user);
                service.update(task.getId(), task);
                user.addtask(task);
                userService.updateUser(userid, user);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
                return ResponseEntity.created(uri).body(task);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Task> insert(@RequestBody Task task){
        service.insert(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(task);
    }

}
