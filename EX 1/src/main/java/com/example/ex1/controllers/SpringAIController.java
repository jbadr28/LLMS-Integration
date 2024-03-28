package com.example.ex1.controllers;


import com.example.ex1.entities.Conversation;
import com.example.ex1.entities.Discussion;
import com.example.ex1.entities.User;
import com.example.ex1.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/spring-ai-openai")
public class SpringAIController {

    @Autowired
    private IUserService userService;

    private final OpenAiChatClient chatClient;
    @Autowired
    public SpringAIController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }
    @GetMapping("/prompts")
    public Object chat(@RequestParam("prompt") String prompt, @RequestParam("userName") String userName) throws Exception {
        User user = userService.getUserByUsername(userName);
        if (user ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username provided doesnot exist, please create a User");
        }
        System.out.println(prompt);

        String response = chatClient.call(prompt);
        Discussion currentDiscussion = new Discussion(prompt,response);

        //get the user conversations
        List<Conversation> userConversations = user.getConversations();
        //check if the the had any conversation
        if(userConversations == null || userConversations.isEmpty()){
            userService.createUserFirstConversation(user,currentDiscussion);
        }else{
            userConversations.getLast().addDiscussion(currentDiscussion);

        }

        userService.save(user);


        return response;

    }
    @GetMapping("/newconversation")
    public Object initiatenewConversation(@RequestParam("prompt") String prompt,@RequestParam("userName")String userName) throws Exception {
        User user = userService.getUserByUsername(userName);
        if (user ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username provided doesnot exist, please create a User");
        }

        String response = chatClient.call(prompt);
        Discussion currentDiscussion = new Discussion(prompt,response);
        userService.createUserFirstConversation(user,currentDiscussion);
        return response;
    }

}
