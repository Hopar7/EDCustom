package com.ho.edcustom.DTO.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoLoginRequest {
    private String code;

    public KakaoLoginRequest(String code) {
        this.code = code;
    }
}
