package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class SocialUserInfoDTO {
    private Long id;
    private String nickname;
    private String email;

    public SocialUserInfoDTO(Long id, String nickname, String email) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
    }
}