package com.ho.edcustom.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ho.edcustom.service.KakaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;

    @ResponseBody
    @GetMapping("/user/kakao/login")
    public String kakaoLogin(@RequestParam String DTO) throws JsonProcessingException {
        return kakaoService.kakaoLogin(DTO); //400에러
    }

//@PostMapping("/user/kakao/login")
//public LoginResponseDto kakaoLogin(@RequestParam String code) throws JsonProcessingException {
//    LoginResponseDto DTO = new LoginResponseDto(kakaoService.kakaoLogin(code));
//    return DTO;
//    }
//    //500에러 - 디버그 400에러
//    //근데 리다이랙트 엔드포인트 call back으로 바꾸면 200 성공함 왜인지 알아야함.
//    //Post,Get 일단 둘다됨
}

