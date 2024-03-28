package com.example.ex1.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversationId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="conversation_id")
    private List<Discussion> discussions = new ArrayList<>();

    public Conversation(ArrayList<Discussion> discussions) {
        this.discussions=discussions;
    }

    public void setDiscussions(ArrayList<Discussion> discussions) {
        this.discussions = discussions;
    }
    public Conversation(){

    }

    public void addDiscussion(Discussion discussion){
        this.discussions.add(discussion);
    }


}
