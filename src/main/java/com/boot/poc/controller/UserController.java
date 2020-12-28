package com.boot.poc.controller;

import com.boot.poc.models.User;
import com.boot.poc.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService daoService;


    //Retrieve All Users
    @GetMapping(path = "/users")
    public List<User> getAllUser() {
        return daoService.findAll();
    }

    //retrieve single user
    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = daoService.findOne(id);
        /*if (user == null) {
            throw new UserNotFoundException("Id-" + id);
        }*/
        return user;
    }

    //Save user
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = daoService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //Completely Replace user
    @PutMapping(path = "/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable int id) {
        User savedUser = daoService.update(id,user);
        return (savedUser!=null)?ResponseEntity.ok().build():ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        User deletedUser = daoService.deleteUser(id);
        /*if (deletedUser == null) {
            throw new UserNotFoundException("Id-" + id);
        }*/
        return ResponseEntity.noContent().build();
    }
}
