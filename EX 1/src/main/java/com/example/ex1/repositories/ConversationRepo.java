package com.example.ex1.repositories;

import com.example.ex1.entities.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepo extends JpaRepository<Conversation,Long> {

}
