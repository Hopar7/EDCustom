package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.Request.EmailRequest;
import com.ho.edcustom.DTO.Request.LoginRequest;
import com.ho.edcustom.DTO.Request.RegisterRequest;
import com.ho.edcustom.DTO.Request.TokenRequest;
import com.ho.edcustom.DTO.Response.LoginResponse;
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
    public void register(@RequestBody RegisterRequest DTO)
    {
        memberService.createMember(DTO.getName(),DTO.getEmail(), DTO.getPassword());
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest DTO) {
        LoginResponse Response = new LoginResponse(memberService.loginMember(DTO.getEmail(),DTO.getPassword()));
        return Response;
    }

    @PostMapping("/findbodybytoken")
    public String findBodyByToken(@RequestBody TokenRequest DTO)
    {
        return jwtTokenProvider.getClaimsFromToken(DTO.getToken());

    }

    @PostMapping("/alreadyusingemail")
    public boolean alreadyUsingEmail(@RequestBody EmailRequest DTO)
    {
        return memberService.alreadyUsingemail(DTO.getEmail());
    }

    @GetMapping("/hello")
    public String hellocontroller(){
        return "hello world";

    }
}

