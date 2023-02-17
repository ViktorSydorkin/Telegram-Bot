package com.example.englishstudybot.repository;

import com.example.englishstudybot.entity.Preposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepositionRepository extends JpaRepository<Preposition, Integer> {
    Preposition findByPreposition(String preposition);
}
