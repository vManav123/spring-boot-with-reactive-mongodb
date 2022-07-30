package com.reactive.mongodb.controller;

import com.reactive.mongodb.model.User;
import com.reactive.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path ="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/")
    public Flux<User> getAll()
    {
        return userService.getAllUser();
    }

    @GetMapping(path = "/{id}")
    public Mono<User> getById(@PathVariable long id)
    {
        return userService.getUserById(id);
    }

}