package br.edu.ifpb.dac.arthur.house.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TokenDTO {

    @NotBlank
    private String token;

    @NotNull
    private SystemUserDto systemUserDto;

    public TokenDTO() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SystemUserDto getSystemUserDto() {
        return systemUserDto;
    }

    public void setSystemUserDto(SystemUserDto systemUserDto) {
        this.systemUserDto = systemUserDto;
    }
}