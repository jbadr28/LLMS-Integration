package com.example.ex1.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String userName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="user_id")
    private List<Conversation> conversations = new ArrayList<>();


    public User(String userName) {
        this.userName=userName;
    }

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void addConversation(Conversation conv){
        this.conversations.add(conv);
    }

}
