package com.example.ex1.service;

import com.example.ex1.entities.Conversation;
import com.example.ex1.repositories.ConversationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IConversationService {
    @Autowired
    private ConversationRepo conversationRepo;



    public Conversation save(Conversation conv){
        return conversationRepo.save(conv);
    }


}
