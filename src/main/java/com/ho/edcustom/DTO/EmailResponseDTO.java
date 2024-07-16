package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@NoArgsConstructor
public class EmailResponseDTO {
    private String email;

    public EmailResponseDTO(String email) {
        this.email = email;
    }
}
