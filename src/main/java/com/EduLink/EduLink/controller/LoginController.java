package com.EduLink.EduLink.controller;

import com.EduLink.EduLink.model.DTO.LoginRequestDTO;
import com.EduLink.EduLink.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(LoginRequestDTO loginRequestDTO){
        if (loginRequestDTO.getUsername() != null && loginRequestDTO.getPassword() != null &&
            !loginRequestDTO.getUsername().isEmpty() && !loginRequestDTO.getPassword().isEmpty()){
            if (userService.findByUsernameAndPassword(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())!=null){
                return ResponseEntity.ok( "User Logged in Successfully");
            }else{
                return ResponseEntity.status(404).body("User Not Found");
            }
        }else if (loginRequestDTO.getEmail() != null && loginRequestDTO.getPassword() != null &&
                !loginRequestDTO.getEmail().isEmpty() && !loginRequestDTO.getPassword().isEmpty()){
            if (userService.findByEmailAndPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())!=null){
                return ResponseEntity.ok( "User Logged in Successfully");
            }else{
                return ResponseEntity.status(404).body("User Not Found");
            }
        }else{
            return ResponseEntity.status(404).body("User Not Found");
        }
    }
}
