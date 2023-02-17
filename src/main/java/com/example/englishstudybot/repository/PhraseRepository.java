package com.example.englishstudybot.repository;

import com.example.englishstudybot.entity.Phrase;
import com.example.englishstudybot.entity.Preposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    Phrase findByPreposition(Preposition preposition);
}
