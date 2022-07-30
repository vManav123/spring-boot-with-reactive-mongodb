package com.reactive.mongodb.service;

import com.reactive.mongodb.model.User;
import com.reactive.mongodb.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Test
    void getAllUser() {
        Flux<User> userFlux = userRepository.findAll();
    }

    @Test
    void getUserById() {
    }

    @Test
    void getUserBetweenThisAge() {
    }

    @Test
    void insertUser() {
    }

    @Test
    void updateUser() {
    }
}
