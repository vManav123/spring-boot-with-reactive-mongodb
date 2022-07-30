package com.reactive.mongodb.service;

import com.reactive.mongodb.model.User;
import com.reactive.mongodb.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Flux<User> getAllUser() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Flux<User> getUserBetweenThisAge(int minAge , int maxAge) {
        return userRepository.findByAgeBetween(Range.closed(minAge , maxAge));
    }

    public Mono<User> insertUser(Mono<User> user) {
        return user.flatMap(userRepository::insert);
    }

    public Mono<User> updateUser(User user , long id) {
        return userRepository
                .findById(id)
                .doOnNext(u -> u.setUser_id(id))
                .flatMap(userRepository::save);
    }

}
