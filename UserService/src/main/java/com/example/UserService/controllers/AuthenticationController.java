package com.example.UserService.controllers;

import com.example.UserService.dtos.LoginUserDto;
import com.example.UserService.dtos.RegisterUserDto;
import com.example.UserService.entities.User;
import com.example.UserService.responses.LoginResponse;
import com.example.UserService.services.AuthenticationService;
import com.example.UserService.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterUserDto registerUserDto) {
        return authenticationService.registerUser(registerUserDto);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginUserDto loginUserDto) {
        User loginUser = authenticationService.loginUser(loginUserDto);

        String jwtToken = jwtService.generateToken(loginUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return loginResponse;
    }
}
