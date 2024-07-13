package com.ho.edcustom.DTO;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final String token;

    public LoginResponseDto(String token) {
        this.token = token;
    }
}