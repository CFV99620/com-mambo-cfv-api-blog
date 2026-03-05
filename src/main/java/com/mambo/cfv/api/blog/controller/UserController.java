package com.mambo.cfv.api.blog.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.mambo.cfv.api.blog.model.User;
import com.mambo.cfv.api.blog.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Long id) {
        log.info("[UserController] Buscando usuario con ID: {}", id);
        return userService.findByUserId(id)
                .map(user -> {
                    log.info("[UserController] Usuario encontrado: {}", user.getUsername());
                    return user;
                })
                .orElseThrow(() -> {
                    log.warn("[UserController] Usuario con ID {} no encontrado", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
                });
    }

    @GetMapping("/list")
    public List<User> allUser() {
        log.info("[UserController] Buscando todos los usuarios");
        return userService.userList();
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        log.info("[UserController] Guardando usuario: {}", user.getUsername());
        return userService.userSave(user);
    }
}
