package com.ho.edcustom.DTO.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GPTRequest {
    private String message;

    public GPTRequest(String message)
    {
        this.message=message;
    }
}
