package com.CMPE321.backend.controller;

import com.CMPE321.backend.User;
import com.CMPE321.backend.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    String loginPage(){
        Optional<User> me = userRepository.getUser("efeemantarci");
        if(me.isPresent()){
            return me.get().toString();
        }
        else{
            return "user not found";
        }
    }
}
