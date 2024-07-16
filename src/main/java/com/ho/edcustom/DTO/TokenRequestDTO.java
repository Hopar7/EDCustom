package com.ho.edcustom.DTO;

import lombok.Getter;

@Getter
public class RequestTokenDTO {
    private String token;

    public RequestTokenDTO(String token) {
        this.token = token;
    }
}
