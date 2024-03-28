package com.example.ex1.openai.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.ContentHandler;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choice {

    private int index;
    private ChatGPTMessage message;

    public ChatGPTMessage getMessage() {
        return this.message;
    }
}
