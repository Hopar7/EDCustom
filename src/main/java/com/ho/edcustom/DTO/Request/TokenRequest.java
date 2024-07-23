package com.ho.edcustom.DTO.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenRequest {
    private String token;

    public TokenRequest(String token) {
        this.token = token;
    }
}
