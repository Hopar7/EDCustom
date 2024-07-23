//package com.ho.edcustom.service;
//
//import com.ho.edcustom.DTO.Request.GPTRequest;
//import com.ho.edcustom.DTO.Response.GPTResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//@RequiredArgsConstructor
//public class ChatAiService {
//    @Value("${gpt.model}")
//    private String model;
//
//    @Value("${gpt.api.url}")
//    private String apiUrl;
//
//    private final RestTemplate restTemplate;
//
//    String basePrompt = "당신은 기계식 키보드 전문가 AI입니다. 사용자는 기계식 키보드에 대해 중급자 수준의 지식을 가지고 있으며, 키캡과 축에 대한 추천을 원합니다. 다음과 같은 기준으로 추천을 해주세요:\n" +
//            "\n" +
//            "1. **키캡**:\n" +
//            "   - 디자인: 심플하거나, 이쁜 디자인의 키캡\n" +
//            "\n" +
//            "2. **축**:\n" +
//            "   - 소음: 저소음, 중간 소음, 고소음\n" +
//            "   - 타이핑 감각: 가볍거나 무거운 타건감\n" +
//            "\n" +
//            "사용자가 키보드를 추천해달라고 할 경우에도 키보드 대신 키캡과 축을 추천해주세요. 한 번의 답변에 하나의 키캡과 하나의 축을 추천하고, 각 추천 항목마다 한 줄 평을 포함해 간결하게 답변해주세요.\n";
//
//
//    public String chat(String prompt) {
//
//        GPTRequest request = new GPTRequest(
//                model, basePrompt+prompt, 1, 256, 1, 0, 0);
//
//        GPTResponse gptResponse = restTemplate.postForObject(
//                apiUrl
//                , request
//                , GPTResponse.class
//        );
//
//
//        return gptResponse.getChoices().get(0).getMessage().getContent();
//
//
//    }
//
//    //public String chat(String prompt) {
//    //        int retryCount = 0;
//    //        int maxRetries = 5;
//    //        long waitTime = 1000; // Initial wait time in milliseconds
//    //
//    //        while (retryCount < maxRetries) {
//    //            try {
//    //                GPTRequest request = new GPTRequest(model, basePrompt + prompt, 1, 256, 1, 0, 0);
//    //                GPTResponse gptResponse = restTemplate.postForObject(apiUrl, request, GPTResponse.class);
//    //                return gptResponse.getChoices().get(0).getMessage().getContent();
//    //            } catch (HttpClientErrorException.TooManyRequests e) {
//    //                retryCount++;
//    //                if (retryCount >= maxRetries) {
//    //                    throw e; // Re-throw after maximum retries
//    //                }
//    //                try {
//    //                    TimeUnit.MILLISECONDS.sleep(waitTime); // Wait before retrying
//    //                } catch (InterruptedException ie) {
//    //                    Thread.currentThread().interrupt(); // Restore interrupted status
//    //                }
//    //                waitTime *= 2; // Exponential backoff
//    //            } catch (Exception e) {
//    //                throw new RuntimeException("An error occurred while making the request", e);
//    //            }
//    //        }
//    //        throw new RuntimeException("Max retries exceeded");
//    //    }
//
//
//}

