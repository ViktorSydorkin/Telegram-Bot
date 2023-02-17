package com.example.englishstudybot.repository;

import com.example.englishstudybot.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    Word findByUkrainianWord(String ukrainian);
}
