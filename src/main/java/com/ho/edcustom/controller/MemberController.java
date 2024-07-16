package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.*;
import com.ho.edcustom.Jwt.JwtTokenProvider;
import com.ho.edcustom.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDTO DTO)
    {
        memberService.createMember(DTO.getName(),DTO.getEmail(), DTO.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO DTO) {
        LoginResponseDTO Response = new LoginResponseDTO(memberService.loginMember(DTO.getEmail(),DTO.getPassword()));
        return Response;
    }
    @PostMapping("/finduserbytoken")
    public EmailResponseDTO findUserByToken(@RequestBody TokenRequestDTO DTO)
    {
        EmailResponseDTO Response = new EmailResponseDTO(jwtTokenProvider.getEamilFromToken(DTO.getToken()));
        return Response;
    }

    @PostMapping("/alreadyusingemail")
    public BoolResponseDTO alreadyUsingEmail(@RequestBody EmailRequestDTO DTO)
    {
        BoolResponseDTO Response = new BoolResponseDTO(memberService.alreadyUsingemail(DTO.getEmail()));
        return Response;
    }

    @GetMapping("/hello")
    public String hellocontroller(){
        return "hello world";

    }
}

