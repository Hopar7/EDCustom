package com.ho.edcustom.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class BoolResponseDTO {
    private Boolean aboolean;

    public BoolResponseDTO(Boolean aboolean) {
        this.aboolean = aboolean;
    }

}
