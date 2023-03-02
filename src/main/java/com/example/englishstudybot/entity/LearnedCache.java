package com.example.englishstudybot.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class LearnedCache {
    private List<Long> learnedCache;
}
