package com.example.B2Bproject.controller;

import com.example.B2Bproject.modeliA.ChatCompletionRequest;
import com.example.B2Bproject.modeliA.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OpenAiController {
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/hiOpenaiApi")
    public String getOpenaiResponse(@RequestBody String prompt) {
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest("gpt-3.5-turbo", prompt);
        ChatCompletionResponse response=restTemplate.postForObject("https://api.openai.com/v1/chat/completions",chatCompletionRequest,ChatCompletionResponse.class);
        return response.getChoices().get(0).getMessage().getContent();

    }
}
