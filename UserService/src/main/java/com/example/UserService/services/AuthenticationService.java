package com.example.UserService.services;

import com.example.UserService.dtos.LoginUserDto;
import com.example.UserService.dtos.RegisterUserDto;
import com.example.UserService.entities.User;
import com.example.UserService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public User registerUser(RegisterUserDto registerUserDto) {
        User newUser = new User();

        newUser.setMail(registerUserDto.getMail());
        newUser.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        newUser.setUsername(registerUserDto.getUsername());

        return userRepository.saveAndFlush(newUser);
    }

    public User loginUser(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getMail(),loginUserDto.getPassword()));

        return userRepository.findByMail(loginUserDto.getMail()).orElseThrow();
    }
}
