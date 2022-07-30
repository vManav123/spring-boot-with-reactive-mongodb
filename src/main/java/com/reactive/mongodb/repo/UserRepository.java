package com.reactive.mongodb.repo;

import com.reactive.mongodb.model.User;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,Long> {
    Flux<User> findByAgeBetween(Range<Integer> closed);
}
