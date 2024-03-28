package com.example.ex1.openai.api;

import lombok.Data;

import java.util.List;

@Data
public class ChatGPTResponse {
    private List<Choice> choices;


    public List<Choice> getChoices() {
        return  this.choices;
    }
}
