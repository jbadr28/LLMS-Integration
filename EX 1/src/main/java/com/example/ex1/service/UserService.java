package com.example.ex1.service;

import com.example.ex1.entities.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User save(User user);


    User getUserByUsername(String username);



}
