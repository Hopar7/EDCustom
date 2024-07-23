package com.ho.edcustom.controller;


import com.ho.edcustom.service.ChatAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ai")
@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatAiService chatAiService;

    @GetMapping("/chat")
    public String getResponseFromChatGpt(String prompt) {
        return chatAiService.chat(prompt);
    }
}

