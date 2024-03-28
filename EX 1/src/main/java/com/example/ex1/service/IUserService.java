package com.example.ex1.service;

import com.example.ex1.entities.Conversation;
import com.example.ex1.entities.Discussion;
import com.example.ex1.entities.User;
import com.example.ex1.repositories.ConversationRepo;
import com.example.ex1.repositories.DiscussionRepo;
import com.example.ex1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserService implements UserService{

    @Autowired
    private UserRepo userRepo;



    @Autowired
    private IDiscussionService discussionService;
    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepo.findUserByUserName(username);
        return user.orElse(null);
    }



    public User createUserFirstConversation(User user,Discussion discussion){
        Conversation conv = new Conversation();
        conv.addDiscussion(discussionService.save(discussion));
        user.addConversation(conv);
        return userRepo.save(user);
    }
}
