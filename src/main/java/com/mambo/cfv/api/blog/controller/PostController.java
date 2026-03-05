package com.mambo.cfv.api.blog.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.mambo.cfv.api.blog.model.Post;
import com.mambo.cfv.api.blog.service.PostService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable("id") Long id) {
        log.info("[PostController] Buscando post con ID: {}", id);
        return postService.findByPostId(id)// el metodo espera un opcinal vacio o post
                .map(post -> { // SI EXISTE:
                    log.info("[PostController] Post encontrado: {}", post.getTitle());
                    return post;
                })
                .orElseThrow(() -> {// si esta vacio: le damos instrucciones
                    log.warn("[PostController] Post con ID {} no encontrado", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
                });
    }

    @GetMapping("/list")
    public List<Post> allPost() {
        log.info("[PostController] Buscando todos los posts");
        return postService.postList();
    }

    @PostMapping("/save")
    public Post savePost(@RequestBody Post post) {
        log.info("[PostController] Guardando post: {}", post.getTitle());
        return postService.postSave(post);
    }
}
