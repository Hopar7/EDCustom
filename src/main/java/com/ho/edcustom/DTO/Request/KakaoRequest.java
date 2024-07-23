package com.ho.edcustom.DTO.Request;

import lombok.Getter;

@Getter
public class KakaoRequest {
    private String code;
    public KakaoRequest(String code)
    {
        this.code=code;
    }


}
