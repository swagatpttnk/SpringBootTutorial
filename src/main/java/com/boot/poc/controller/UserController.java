package com.boot.poc.controller;

import com.boot.poc.excepions.UserNotFoundException;
import com.boot.poc.models.User;
import com.boot.poc.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
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
    public User getUser(@PathVariable int id) throws UserNotFoundException {
        User user = daoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("Id-" + id);
        }
        return user;
    }

    //Save user
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
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
    public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable int id) throws UserNotFoundException {
        User savedUser = daoService.update(id,user);
        if(savedUser==null){
            throw new UserNotFoundException("Id-" + id);
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) throws UserNotFoundException {
        User deletedUser = daoService.deleteUser(id);
        if (deletedUser == null) {
            throw new UserNotFoundException("Id-" + id);
        }
        return ResponseEntity.noContent().build();
    }
}
