package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@NoArgsConstructor
public class EmailRequestDTO {
    private String email;

    public EmailRequestDTO(String email) {
        this.email = email;
    }
}
