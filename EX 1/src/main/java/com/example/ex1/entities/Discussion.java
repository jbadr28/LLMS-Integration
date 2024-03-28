package com.example.ex1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discussionId;

    @Column(length = 2000)
    private String question;

    @Column(length = 2000)
    private String answer;

    public Discussion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
