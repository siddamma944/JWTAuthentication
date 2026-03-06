package com.example.UserService.controller;

import com.example.UserService.entity.UserEntity;
import com.example.UserService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
       UserEntity userResult= userService.createUser(user);
        return new ResponseEntity<>(userResult, HttpStatus.CREATED);

    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id){
       UserEntity user= userService.getUserById(id);
       return new ResponseEntity<>(user,HttpStatus.OK);

    }
}
