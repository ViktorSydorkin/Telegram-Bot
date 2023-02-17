package com.example.englishstudybot.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Meaning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meaning_id")
    private int id;
    @Column(name = "meaning")
    private String meaning;

    @Override
    public String toString() {
        return  meaning +" ";
    }
}
