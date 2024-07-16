package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
public class KakaoRequestDTO {
    private String code;
    public KakaoRequestDTO(String code)
    {
        this.code=code;
    }


}
