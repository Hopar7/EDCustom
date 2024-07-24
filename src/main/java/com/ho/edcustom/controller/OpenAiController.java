package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.Request.GPTRequest;
import com.ho.edcustom.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OpenAiController {
    private final OpenAiService openAiService;
    @PostMapping("/ai/generate")
    public Map generate(@RequestBody GPTRequest DTO) {
        return openAiService.generate(DTO.getMessage());
    }
}