package com.example.UserService.service;

import com.example.UserService.entity.UserEntity;
import com.example.UserService.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;
    UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    public UserEntity createUser(UserEntity user){
        return userRepo.save(user);

    }
    public UserEntity getUserById(Long id){
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("user not foung with id is "+ id));
    }
}
