package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoLoginRequestDTO {
    private String code;

    public KakaoLoginRequestDTO(String code) {
        this.code = code;
    }
}
