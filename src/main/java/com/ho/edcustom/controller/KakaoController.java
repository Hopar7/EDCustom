package com.ho.edcustom.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ho.edcustom.DTO.KakaoRequestDTO;
import com.ho.edcustom.service.KakaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;
    @GetMapping("/user/kakao/login")
    public String kakaoLogin(@RequestBody KakaoRequestDTO DTO) throws JsonProcessingException {
        return kakaoService.kakaoLogin(DTO.getCode());
    }

}
