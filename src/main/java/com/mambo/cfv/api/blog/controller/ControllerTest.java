package com.mambo.cfv.api.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mambo.cfv.api.blog.model.Post;
import com.mambo.cfv.api.blog.model.User;
import com.mambo.cfv.api.blog.service.PostService;
import com.mambo.cfv.api.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/saludar")
public class ControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/Hola")
    public String saludo() {
        return "Hola";
    }

    @GetMapping("/Adios")
    public String bye() {
        return "Adios";
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Long id) {
        log.info("[ControllerTest] Buscando usuario con ID: {}", id);
        return userService.findByUserId(id)
                .map(user -> {
                    log.info("[ControllerTest] Usuario encontrado: {}", user.getUsername());
                    return user;
                })
                .orElseThrow(() -> {
                    log.warn("[ControllerTest] Usuario con ID {} no encontrado", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
                });
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable("id") Long id) {
        log.info("[ControllerTest] Buscando post con ID: {}", id);
        return postService.findByPostId(id)
                .map(post -> {
                    log.info("[ControllerTest] Post encontrado: {}", post.getTitle());
                    return post;
                })
                .orElseThrow(() -> {
                    log.warn("[ControllerTest] Post con ID {} no encontrado", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
                });
    }

    @GetMapping("/post/list")
    public List<Post> allPost() {
        return postService.postList();
    }

}
