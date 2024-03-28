package com.example.ex1.openai.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ChatGPTMessage {

    private String role;
    private String content;

    public ChatGPTMessage(String role, String content) {
        this.role=role;
        this.content=content;
    }


    public String getContent() {
        return this.content;
    }
}
