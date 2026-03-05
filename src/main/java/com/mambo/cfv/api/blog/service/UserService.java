package com.mambo.cfv.api.blog.service;

import com.mambo.cfv.api.blog.model.User;
import com.mambo.cfv.api.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByUserId(Long id) {
        return userRepository.findById(id);
    }

    public User userSave(User user) {
        return userRepository.save(user);
    }

    public List<User> userList() {
        return userRepository.findAll();
    }
}