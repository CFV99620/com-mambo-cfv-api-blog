package com.mambo.cfv.api.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mambo.cfv.api.blog.model.User;
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

    @GetMapping("/Hola")
    public String saludo() {
        return "Hola";
    }

    @GetMapping("/Adios")
    public String bye() {
        return "Adios";
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        log.info("[ControllerTest] Buscando usuario con ID: {}", id);
        return userService.findById(id)
                .map(user -> {
                    log.info("[ControllerTest] Usuario encontrado: {}", user.getUsername());
                    return user;
                })
                .orElseThrow(() -> {
                    log.warn("[ControllerTest] Usuario con ID {} no encontrado", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
                });
    }

}
