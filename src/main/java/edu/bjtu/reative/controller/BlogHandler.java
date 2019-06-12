package edu.bjtu.reative.controller;

import edu.bjtu.reative.entity.Blog;
import edu.bjtu.reative.service.BlogService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class BlogHandler {
    private final BlogService blogService;
    public BlogHandler(BlogService blogService) {
        this.blogService = blogService;
    }
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(blogService.findOne(id), Blog.class);
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(blogService.findAll(), Blog.class);
    }
    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Blog> blog = request.bodyToMono(Blog.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(blog.flatMap(blogService::createBlog), Blog.class);
    }
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(blogService.delete(id), boolean.class);
    }
}