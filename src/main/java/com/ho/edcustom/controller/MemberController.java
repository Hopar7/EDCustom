package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.*;
import com.ho.edcustom.Jwt.JwtTokenProvider;
import com.ho.edcustom.service.MemberService;
import io.jsonwebtoken.Claims;
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
    @PostMapping("/findemailbytoken")
    public EmailResponseDTO findEmailByToken(@RequestBody TokenRequestDTO DTO)
    {
        EmailResponseDTO Response = new EmailResponseDTO(jwtTokenProvider.getEamilFromToken(DTO.getToken()));
        return Response;
    }
    @PostMapping("/findbodybytoken")
    public Claims findBodyByToken(@RequestBody TokenRequestDTO DTO)
    {
        Claims claims =jwtTokenProvider.getClaimsFromToken(DTO.getToken());
        return claims;
    }

    @PostMapping("/alreadyusingemail")
    public boolean alreadyUsingEmail(@RequestBody EmailRequestDTO DTO)
    {
        return memberService.alreadyUsingemail(DTO.getEmail());
    }

    @GetMapping("/hello")
    public String hellocontroller(){
        return "hello world";

    }
}

