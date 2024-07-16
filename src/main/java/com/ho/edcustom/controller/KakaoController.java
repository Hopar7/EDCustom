package com.ho.edcustom.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ho.edcustom.DTO.KakaoLoginRequestDTO;
import com.ho.edcustom.DTO.LoginRequestDTO;
import com.ho.edcustom.DTO.LoginResponseDTO;
import com.ho.edcustom.service.KakaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;

    @ResponseBody
    @PostMapping("/social/kakao/login")
    public LoginResponseDTO kakaoLogin(@RequestBody KakaoLoginRequestDTO DTO) throws JsonProcessingException {
        LoginResponseDTO Response = new LoginResponseDTO(kakaoService.kakaoLogin(DTO.getCode()));
        return Response;
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

