package com.ho.edcustom.DTO;

import lombok.Getter;

@Getter
public class TokenRequestDTO {
    private String token;

    public TokenRequestDTO(String token) {
        this.token = token;
    }
}
