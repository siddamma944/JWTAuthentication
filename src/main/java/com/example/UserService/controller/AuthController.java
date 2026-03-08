package com.example.UserService.controller;

import com.example.UserService.DTO.LoginDTO;
import com.example.UserService.entity.UserEntity;
import com.example.UserService.repo.UserRepo;
import com.example.UserService.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private JwtUtil jwtUtil;
    private UserRepo userRepo;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginRequest){
        UserEntity user =userRepo.findByEmail(loginRequest.getEmail());
        if(user==null||!user.getPassword().equals(loginRequest.getPassword())){
            throw new RuntimeException("user credential are not valid check username and password");

        }
        return jwtUtil.genreateToken(user.getUsermail(),user.getRole());


    }
}
