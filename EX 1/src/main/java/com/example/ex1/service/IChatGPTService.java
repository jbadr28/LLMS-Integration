package com.example.ex1.service;

import com.example.ex1.openai.api.ChatGPTRequest;
import com.example.ex1.openai.api.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IChatGPTService implements ChatGPTService{

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;
    @Autowired
    private RestTemplate template;
    @Override
    public String getResponseFromOpenAPI(String prompt) {
        ChatGPTRequest request=new ChatGPTRequest(model, prompt);
        ChatGPTResponse chatGptResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
