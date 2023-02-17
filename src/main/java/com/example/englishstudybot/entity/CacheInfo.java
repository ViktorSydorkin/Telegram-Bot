package com.example.englishstudybot.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CacheInfo {
    private Word word;
    private List<Word> words;
    private Phrase phrase;
    private List<Preposition> prepositions;
    private Phrasal phrasalVerb;
    private List<Phrasal> phrasalVerbs;
    private List<Meaning> meanings;
}
