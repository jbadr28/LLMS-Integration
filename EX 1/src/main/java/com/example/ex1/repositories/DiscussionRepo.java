package com.example.ex1.repositories;

import com.example.ex1.entities.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepo extends JpaRepository<Discussion,Long> {
}
