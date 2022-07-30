package com.reactive.mongodb.config;

import com.reactive.mongodb.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserEndpointConfig {
    private static final String USER = "/user";

    @Bean
    RouterFunction<ServerResponse> routes(UserHandler handler) {
        return route(GET(USER), handler::all)
                .andRoute(POST(USER), handler::update)
                .andRoute(GET(USER+"/{id}"),handler::get);
    }
}
