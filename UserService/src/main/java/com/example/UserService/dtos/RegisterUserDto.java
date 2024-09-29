package com.example.UserService.dtos;

public class RegisterUserDto {

    private String mail;
    private String username;
    private String password;

    public void setMail(String newMail) {
        this.mail = newMail;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getMail() {
        return this.mail;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

}
