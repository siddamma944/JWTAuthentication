package com.example.UserService.entity;

import com.example.UserService.DTO.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(unique = true)
    private String usermail;
    private String password;
    private UserRole role;
}
