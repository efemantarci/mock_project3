package com.CMPE321.backend.service;

import com.CMPE321.backend.User;
import com.CMPE321.backend.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String getHashedPassword(String pass){
        return passwordEncoder.encode(pass);
    }

    public ResponseEntity<String> authUser(String username,String password){
        Optional<User> wantedUser = userRepository.getUser(username);
        if(wantedUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user not found");
        }

        User user = wantedUser.get();
        if(!passwordEncoder.matches(password, user.getPasswordHash())){
            System.out.printf("Wanted hash : %s, got hash %s ",user.getPasswordHash(),getHashedPassword(password));
            return ResponseEntity.badRequest().body("Incorrect password");
        }
        return ResponseEntity.ok("You are now logged in as " + username);
    }

    public ResponseEntity<User> createUser(String username,String password, String name, String surname, String nationality){
        User newUser = new User(username,getHashedPassword(password),name,surname,nationality);
        userRepository.save(newUser);
        return ResponseEntity.ok(newUser);
    }
}
