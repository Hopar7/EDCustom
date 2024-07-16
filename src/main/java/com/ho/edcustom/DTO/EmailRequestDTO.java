package com.ho.edcustom.DTO;

import lombok.Getter;

@Getter
public class EmailRequestDTO {
    private String email;

    public EmailRequestDTO(String email) {
        this.email = email;
    }
}
