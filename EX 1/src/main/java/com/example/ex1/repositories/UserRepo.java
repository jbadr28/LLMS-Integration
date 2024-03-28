package com.example.ex1.repositories;

import com.example.ex1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> getUserByUserName(String userName)throws Exception;
    Optional<User> findUserByUserName(String userName);


}
