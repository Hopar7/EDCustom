package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoLogincodeDTO {
    private String code;
    public KakaoLogincodeDTO(String code)
    {
        this.code=code;
    }


}
