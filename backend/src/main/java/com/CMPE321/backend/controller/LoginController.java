package com.CMPE321.backend.controller;

import com.CMPE321.backend.User;
import com.CMPE321.backend.UserRepository;
import com.CMPE321.backend.dto.UserCreateRequest;
import com.CMPE321.backend.dto.UserLoginRequest;
import com.CMPE321.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;
    @GetMapping("/")
    String homePage(){
        return "Go to /login";
    }
    @PostMapping("/login")
    String loginPage(@RequestBody UserLoginRequest request){
         ResponseEntity<String> response = authService.authUser(request.getUsername(), request.getPassword());
         return response.getBody();
    }
    @PostMapping("/create")
    User createPage(@RequestBody UserCreateRequest request){
        System.out.printf("Got request with username : %s pass : %s", request.getUsername(), request.getPassword());
        ResponseEntity<User> response = authService.createUser(
                request.getUsername(),
                request.getPassword(),
                request.getName(),
                request.getSurname(),
                request.getNationality()
        );
        return response.getBody();
    }
}
