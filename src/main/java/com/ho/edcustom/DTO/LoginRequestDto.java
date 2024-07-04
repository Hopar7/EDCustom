package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {

    private String userid;
    private String password;

    public LoginRequestDto(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }
}
