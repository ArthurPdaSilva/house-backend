package br.edu.ifpb.dac.arthur.house.presentation.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class LoginDto {


    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public LoginDto() {}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
