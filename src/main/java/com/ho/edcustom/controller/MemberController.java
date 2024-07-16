package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.LoginRequestDTO;
import com.ho.edcustom.DTO.LoginResponseDTO;
import com.ho.edcustom.DTO.RegisterRequestDTO;
import com.ho.edcustom.Jwt.JwtTokenProvider;
import com.ho.edcustom.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDTO DTO)
    {
        userService.createMember(DTO.getName(),DTO.getEmail(), DTO.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO DTO) {
        LoginResponseDTO Response = new LoginResponseDTO(userService.loginMember(DTO.getEmail(),DTO.getPassword()));
        return Response;
    }
    @PostMapping("/finduserbytoken")
    public String findUserByToken(@RequestParam String token)
    {
        return jwtTokenProvider.getEamilFromToken(token);
    }

    @PostMapping("/alreadyusingemail")
    public boolean alreadyUsingEmail(@RequestParam String email)
    {
        return userService.alreadyUsingemail(email);
    }

    @GetMapping("/hello")
    public String hellocontroller(){
        return "hello world";

    }
}

