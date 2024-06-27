package com.ho.edcustom.controller;

import com.ho.edcustom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestParam String name,@RequestParam String password)
    {
        userService.registerUser(name,password);
    }

    @GetMapping("/hello")
    public String hellocontroller(){
        return "hello world";
    }
}
