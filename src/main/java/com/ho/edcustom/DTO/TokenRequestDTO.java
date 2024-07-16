package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@NoArgsConstructor
public class TokenRequestDTO {
    private String token;

    public TokenRequestDTO(String token) {
        this.token = token;
    }
}
