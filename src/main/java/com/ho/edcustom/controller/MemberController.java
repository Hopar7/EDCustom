package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.LoginRequestDto;
import com.ho.edcustom.DTO.LoginResponseDto;
import com.ho.edcustom.JwtTokenProvider;
import com.ho.edcustom.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService userService;
    private final JwtTokenProvider jwtTokenProvider;
//    private LoginRequestDto loginRequestDto;
//    private LoginResponseDto loginResponseDto;

    @PostMapping("/register")
    public void register(@RequestParam String name,@RequestParam String userid,@RequestParam String password)
    {
        userService.createMember(name,userid,password);
    }
    @PostMapping("/login")
    public String login(@RequestParam String name,@RequestParam String password) {
        return userService.loginMember(name,password);
    }
    @PostMapping("/finduserbytoken")
    public String findUserByToken(@RequestParam String token)
    {
        return jwtTokenProvider.getUserIdFromToken(token);
    }

    @PostMapping("/alreadyusingid")
    public boolean alreadyUsingId(@RequestParam String userid)
    {
        return userService.alreadyUsingid(userid);
    }
//@PostMapping("/register")
//    public void register(@RequestBody MemberDTO memberDTO) {
//        userService.createMember(memberDTO.getUserid(), memberDTO.getPassword());
//    }
//
//    @PostMapping("/login")
//    public MemberDTO login(@RequestBody MemberDTO memberDTO) {
//        return userService.login(memberDTO.getUserid(), memberDTO.getPassword());
//    }


    @GetMapping("/hello")
    public String hellocontroller(){
        return "hello world";

    }
}

