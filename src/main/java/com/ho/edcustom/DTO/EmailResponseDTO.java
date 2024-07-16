package com.ho.edcustom.DTO;

import lombok.Getter;

@Getter
public class EmailResponseDTO {
    private String email;

    public EmailResponseDTO(String email) {
        this.email = email;
    }
}
