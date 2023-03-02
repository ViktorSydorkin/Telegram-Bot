package com.example.englishstudybot.botcontext;

import com.example.englishstudybot.cache.DataCache;
import com.example.englishstudybot.entity.*;
import com.example.englishstudybot.repository.PhrasalRepository;
import com.example.englishstudybot.repository.PhraseRepository;
import com.example.englishstudybot.repository.PrepositionRepository;
import com.example.englishstudybot.repository.WordRepository;
import com.example.englishstudybot.util.Constants;
import com.example.englishstudybot.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class StateProcessorImpl implements StateProcessor {
    @Autowired
    private WordRepository wordRepository;
    @Autowired
    private PhraseRepository phraseRepository;
    @Autowired
    private PrepositionRepository prepositionRepository;
    @Autowired
    private PhrasalRepository phrasalRepository;
    @Autowired
    private DataCache dataCache;

    @Override
    public SendMessage startProcess(Message message) {
        dataCache.clearCacheInfo(message.getFrom().getId());
        dataCache.clearLearnedCache(message.getFrom().getId());
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(Constants.START)
                .replyMarkup(Util.defaultKeyboard()).build();
    }

    @Override
    public SendMessage helpProcess(Message message) {
        dataCache.clearCacheInfo(message.getFrom().getId());
        dataCache.clearLearnedCache(message.getFrom().getId());
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(Constants.HELP)
                .replyMarkup(Util.defaultKeyboard()).build();
    }

    @Override
    public SendMessage stopProcess(Message message) {
        dataCache.clearCacheInfo(message.getFrom().getId());
        dataCache.clearLearnedCache(message.getFrom().getId());
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(Constants.STOP)
                .replyMarkup(Util.defaultKeyboard()).build();
    }

    @Override
    public SendMessage waitProcess(Message message) {
        dataCache.clearCacheInfo(message.getFrom().getId());
        dataCache.clearLearnedCache(message.getFrom().getId());
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(Constants.WAIT)
                .replyMarkup(Util.defaultKeyboard()).build();
    }

    @Override
    public SendMessage studyProcess(Message message) {
        dataCache.clearCacheInfo(message.getFrom().getId());
        dataCache.clearLearnedCache(message.getFrom().getId());
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text("Choose the type of studying:")
                .replyMarkup(Util.studyAskKeyboard())
                .build();
    }

    @Override
    public SendMessage wordProcess(Message message) {
        long userId = message.getFrom().getId();
        dataCache.clearCacheInfo(userId);
        LearnedCache learnedCache = getLearnedCache(userId);
        long wordAmount = wordRepository.count();
        Random random = new Random();
        List<Word> words = new ArrayList<>(4);
        List<Long> randomArray = Util.randomArray(wordAmount, 3);
        for (int i = 0; i < 3; i++) {
            words.add(wordRepository.findById(randomArray.get(i)).orElseThrow(RuntimeException::new));
        }
        Word word;
        long randomWordId = getRandomId(learnedCache, wordAmount, random);
        word = wordRepository.findById(randomWordId).orElseThrow(RuntimeException::new);
        words.add(random.nextInt(4), word);
        learnedCache.getLearnedCache().add(randomWordId);
        dataCache.setLearnedCache(userId, learnedCache);
        dataCache.setCacheInfo(userId, CacheInfo.builder().word(word).words(words).build());
        return Util.createWordsKeyboard(message, dataCache, words, Answer.NONE);
    }

    @Override
    @Transactional
    public SendMessage phraseProcess(Message message) {
        long userId = message.getFrom().getId();
        dataCache.clearCacheInfo(userId);
        LearnedCache learnedCache = getLearnedCache(userId);
        long prepositionAmount = prepositionRepository.count();
        Random random = new Random();
        List<Preposition> prepositions = new ArrayList<>(4);
        List<Long> randomArray = Util.randomArray(prepositionAmount, 3);
        for (int i = 0; i < 3; i++) {
            prepositions.add(prepositionRepository.findById(randomArray.get(i).intValue()).orElseThrow(RuntimeException::new));
        }
        int randomPrepositionId = (int) getRandomId(learnedCache, prepositionAmount, random);
        Preposition temp = prepositionRepository.findById(randomPrepositionId).orElseThrow(RuntimeException::new);
        prepositions.add(random.nextInt(4), temp);
        Phrase phrase = temp.getPhrases().get(random.nextInt(temp.getPhrases().size()));
        learnedCache.getLearnedCache().add((long)randomPrepositionId);
        dataCache.setLearnedCache(userId, learnedCache);
        dataCache.setCacheInfo(userId, CacheInfo.builder().phrase(phrase).prepositions(prepositions).build());
        return Util.createPhrasesKeyboard(message, dataCache, prepositions, Answer.NONE);
    }

    @Override
    @Transactional
    public SendMessage phrasalProcess(Message message) {
        long userId = message.getFrom().getId();
        dataCache.clearCacheInfo(userId);
        LearnedCache learnedCache = getLearnedCache(userId);
        int phrasalVerbsAmount = (int) phrasalRepository.count();
        Random random = new Random();
        List<Phrasal> phrasalVerbs = new ArrayList<>(4);
        List<Long> randomArray = Util.randomArray(phrasalVerbsAmount, 3);
        for (int i = 0; i < 3; i++) {
            phrasalVerbs.add(phrasalRepository.findById(randomArray.get(i).intValue()).orElseThrow(RuntimeException::new));
        }
        int randomPhrasalId = (int) getRandomId(learnedCache, phrasalVerbsAmount, random);
        Phrasal phrasal = phrasalRepository.findById(randomPhrasalId).orElseThrow(RuntimeException::new);
        phrasalVerbs.add(random.nextInt(4), phrasal);
        List<Meaning> meanings = phrasal.getMeanings();
        learnedCache.getLearnedCache().add((long)randomPhrasalId);
        dataCache.setLearnedCache(userId, learnedCache);
        dataCache.setCacheInfo(userId, CacheInfo.builder().phrasalVerb(phrasal).phrasalVerbs(phrasalVerbs).meanings(meanings).build());
        return Util.createPhrasalKeyboard(message, dataCache, phrasalVerbs, Answer.NONE);
    }

    @Override
    public SendMessage wordAnswerCheck(Message message) {
        long userId = message.getFrom().getId();
        String answer = message.getText();
        String correctAnswer = dataCache.getCacheInfo(userId).getWord().getUkrainianWord();
        if (answer.equals(correctAnswer)) return wordProcess(message);
        CacheInfo cacheInfo = dataCache.getCacheInfo(userId);
        Word word = wordRepository.findByUkrainianWord(answer);
        if (word == null)
            return Util.createWordsKeyboard(message, dataCache, cacheInfo.getWords(), Answer.INCORRECT);
        dataCache.getCacheInfo(userId).getWords().remove(word);
        dataCache.setCurrentState(userId, State.WAIT_FOR_TRANSLATION);
        return Util.createWordsKeyboard(message, dataCache, cacheInfo.getWords(), Answer.INCORRECT);
    }

    @Override
    @Transactional
    public SendMessage phraseAnswerCheck(Message message) {
        long userId = message.getFrom().getId();
        String answer = message.getText();
        String correctAnswer = dataCache.getCacheInfo(userId).getPhrase().getPreposition().getPreposition();
        if (answer.equals(correctAnswer)) return phraseProcess(message);
        CacheInfo cacheInfo = dataCache.getCacheInfo(userId);
        Preposition preposition = prepositionRepository.findByPreposition(answer);
        if (preposition == null)
            return Util.createPhrasesKeyboard(message, dataCache, cacheInfo.getPrepositions(), Answer.INCORRECT);
        dataCache.getCacheInfo(userId).getPrepositions().remove(preposition);
        dataCache.setCurrentState(userId, State.WAIT_FOR_MISSING_WORD);
        return Util.createPhrasesKeyboard(message, dataCache, cacheInfo.getPrepositions(), Answer.INCORRECT);
    }

    @Override
    @Transactional
    public SendMessage phrasalAnswerCheck(Message message) {
        long userId = message.getFrom().getId();
        String answer = message.getText();
        String correctAnswer = dataCache.getCacheInfo(userId).getPhrasalVerb().getPhrasalVerb();
        if (answer.equals(correctAnswer)) return phrasalProcess(message);
        CacheInfo cacheInfo = dataCache.getCacheInfo(userId);
        Phrasal phrasal = phrasalRepository.findByPhrasalVerb(answer);
        if (phrasal == null)
            return Util.createPhrasalKeyboard(message, dataCache, cacheInfo.getPhrasalVerbs(), Answer.INCORRECT);
        dataCache.getCacheInfo(userId).getPhrasalVerbs().remove(phrasal);
        dataCache.setCurrentState(userId, State.WAIT_FOR_MEANING);
        return Util.createPhrasalKeyboard(message, dataCache, cacheInfo.getPhrasalVerbs(), Answer.INCORRECT);
    }

    private LearnedCache getLearnedCache(long userId) {
        LearnedCache learnedCache = dataCache.getLearnedCache(userId);
        if(learnedCache==null) learnedCache = LearnedCache.builder().learnedCache(new ArrayList<>()).build();
        return learnedCache;
    }

    private long getRandomId(LearnedCache learnedCache, long idAmount, Random random) {
        long randomWordId = random.nextLong(idAmount) + 1;
        while (learnedCache.getLearnedCache().contains(randomWordId)) randomWordId = random.nextLong(idAmount) + 1;
        return randomWordId;
    }
}
