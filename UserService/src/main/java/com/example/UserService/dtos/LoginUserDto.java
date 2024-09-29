package com.example.UserService.dtos;

public class LoginUserDto {

    private String mail;
    private String password;

    public void setMail(String newMail) {
        this.mail = newMail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getMail() {
        return this.mail;
    }

    public String getPassword() {
        return this.password;
    }
}
