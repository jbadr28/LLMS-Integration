package com.example.ex1.service;

import com.example.ex1.entities.Discussion;

public interface DiscussionService {

    public Discussion save(Discussion discussion);

    public Discussion findbyId(Long id);
}
