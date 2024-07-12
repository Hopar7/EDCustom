package com.ho.edcustom.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ho.edcustom.DTO.KakaoLogincodeDTO;
import com.ho.edcustom.service.KakaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;
    @PostMapping("/user/kakao/login")
    public String kakaoLogin(@RequestParam KakaoLogincodeDTO DTO) throws JsonProcessingException {
        return kakaoService.kakaoLogin(DTO);
    }
    @GetMapping("/kakao/callback")//테스트용 카카오 인가코드 받아오는 엔드포인트 추후 프론트에서 주면 삭제예정
    public String getCode(@RequestParam("code") String code) {
        // "code" 파라미터의 값을 받아옴
        return "Code: " + code;
    }
}
