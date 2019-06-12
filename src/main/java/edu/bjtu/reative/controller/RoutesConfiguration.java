package edu.bjtu.reative.controller;

import edu.bjtu.reative.dao.BlogRepository;
import edu.bjtu.reative.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfiguration {
    @Autowired
    private BlogHandler blogHandler;

    @Bean
    public RouterFunction<ServerResponse> blogRoute() {
        return route(GET("/blog"), blogHandler::findAll)
                .andRoute(GET("/blog/{id}"), blogHandler::findById)
                .andRoute(POST("/blog"), blogHandler::save)
                .andRoute(DELETE("/blog/{id}"), blogHandler::delete);
    }

}