package com.reactive.mongodb.handler;

import com.reactive.mongodb.dto.UserCrudResponse;
import com.reactive.mongodb.model.User;
import com.reactive.mongodb.service.UserService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.http.MediaType.*;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> update(ServerRequest request) {
        Flux<User> flux = request
                .bodyToFlux(UserCrudResponse.class)
                .flatMap(userCrudResponse -> this.userService.updateUser(userCrudResponse.getUser() , userCrudResponse.getId()));
        return defaultWriteResponse(flux);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        return defaultReadResponse(userService.getUserById((long) id(request)));
    }

    public Mono<ServerResponse> all(ServerRequest request) {
        return defaultReadResponse(this.userService.getAllUser());
    }


    @SuppressWarnings("Deprecation")
    private static Mono<ServerResponse> defaultReadResponse(Publisher<User> Users) {
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(Users , User.class);
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<User> User) {
        return Mono
                .from(User)
                .flatMap(p -> ServerResponse
                        .created(URI.create("/User"))
                        .contentType(APPLICATION_JSON)
                        .build()
                );
    }

    private static int id(ServerRequest r) {
        return Integer.parseInt(r.pathVariable("id"));
    }

}
