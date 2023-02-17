package com.example.englishstudybot.repository;

import com.example.englishstudybot.entity.Phrasal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhrasalRepository extends JpaRepository<Phrasal, Integer> {
    Phrasal findByPhrasalVerb(String phrasalVerb);
}
