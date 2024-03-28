package com.example.ex1.openai.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatGPTRequest {
    private String model;
    private List<ChatGPTMessage> messages;

    public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new ChatGPTMessage("user",prompt));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatGPTMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatGPTMessage> messages) {
        this.messages = messages;
    }

    public ChatGPTRequest(String model, List<ChatGPTMessage> messages) {
        this.model = model;
        this.messages = messages;
    }

}
