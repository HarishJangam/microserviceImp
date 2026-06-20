package com.demo.UserService.UserService.service;

import com.demo.UserService.UserService.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(String id) throws Throwable;
}
