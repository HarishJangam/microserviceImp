package com.demo.UserService.UserService.controller;

import com.demo.UserService.UserService.models.User;
import com.demo.UserService.UserService.service.UserService;
import com.demo.UserService.UserService.service.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImp userServiceImp;
    UserService userService;
    public UserController(UserService userService, UserServiceImp userServiceImp){
        this.userService=userService;
        this.userServiceImp = userServiceImp;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user1){
       User user= userService.createUser(user1);
       return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User>getSingleUser(@PathVariable(name="userId") String userId) throws Throwable {
        User user=userService.getUserById(userId);
        return  ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        List<User>allUsers=userServiceImp.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}

