package com.example.ex1.service;

import com.example.ex1.entities.Discussion;
import com.example.ex1.repositories.DiscussionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IDiscussionService implements DiscussionService {

    @Autowired
    public DiscussionRepo discussionRepo;

    public Discussion save(Discussion discussion){
        return discussionRepo.save(discussion);
    }

    public Discussion findbyId(Long id){
        return discussionRepo.findById(id).orElse(null);
    }
}
