package com.ho.edcustom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
public class OpenAiService {
    private final ChatModel chatModel;
    @Autowired
    public OpenAiService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }
    public Map generate(String message) {
        PromptTemplate promptTemplate = new PromptTemplate("당신은 기계식 키보드 전문가 AI입니다. 사용자는 기계식 키보드에 대해 중급자 수준의 지식을 가지고 있으며, 키캡과 축에 대한 추천을 원합니다. 다음과 같은 기준으로 추천을 해주세요:\n" +
                "\n" +
                "1. **키캡**:\n" +
                "   - 디자인: 심플하거나, 이쁜 디자인의 키캡\n" +
                "   - 색깔: 사용자가 요청한 색깔과 일치하는 키캡\n" +
                "\n" +
                "2. **축**:\n" +
                "   - 소음: 저소음, 중간 소음, 고소음\n" +
                "   - 타이핑 감각: 가볍거나 무거운 타건감\n" +
                "   - 특정 축(예: 청축, 적축 등): 요청된 축과 일치하는 축\n" +
                "\n" +
                "사용자가 \"{Message}\"라고 요청할 경우:\n" +
                "1. 메시지의 첫 번째 부분이 형용사인 경우: 해당 형용사와 일치하는 키캡을 추천.\n" +
                "2. 첫 번째 부분이 색깔인 경우: 해당 색깔과 일치하는 키캡을 추천.\n" +
                "3. 메시지의 두 번째 부분이 형용사인 경우: 해당 형용사와 일치하는 축을 추천.\n" +
                "4. 두 번째 부분이 특정 축에 대한 언급인 경우: 해당 축과 일치하는 축을 추천.\n" +
                "\n" +
                "예를 들어, \"Message\", (이쁘고 조용한) 키보드 추천해줘 라고 하였을 때, 앞의 형용사는 키캡을, 뒤의 형용사는 스위치를 추천해 주세요. 한 번의 답변에 하나의 키캡과 하나의 축을 추천하고, 각 추천 항목마다 한 줄 평을 포함해 간결하게 답변해주세요.\n");

        Prompt prompt = promptTemplate.create(Map.of("Message", message));
        return Map.of("generation", chatModel.call(prompt).getResult());
    }
}
