package com.example.englishstudybot.botcontext;

import com.example.englishstudybot.cache.DataCache;
import com.example.englishstudybot.entity.State;
import com.example.englishstudybot.util.Constants;
import com.example.englishstudybot.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
@Component
public class MessageProcessorImpl implements MessageProcessor {
    @Autowired
    private DataCache dataCache;
    @Autowired
    private StateProcessor stateProcessor;

    @Override
    public SendMessage process(State state, Message message) {
        long userId = message.getFrom().getId();
        long chatId = message.getChatId();
        try {
            switch (state) {
                case START -> {
                    dataCache.clearCacheInfo(userId);
                    dataCache.setCurrentState(userId, State.WAIT);
                    return stateProcessor.startProcess(message);
                }
                case STUDY -> {
                   dataCache.setCurrentState(userId, State.WAIT);
                    return stateProcessor.studyProcess(message);
                }
                case WORDS -> {
                    dataCache.setCurrentState(userId, State.WAIT_FOR_TRANSLATION);
                    return stateProcessor.wordProcess(message);
                }
                case WAIT_FOR_TRANSLATION -> {
                    dataCache.setCurrentState(userId, State.WAIT_FOR_TRANSLATION);
                    return stateProcessor.wordAnswerCheck(message);
                }
                case PHRASES -> {
                    dataCache.setCurrentState(userId, State.WAIT_FOR_MISSING_WORD);
                    return stateProcessor.phraseProcess(message);
                }
                case WAIT_FOR_MISSING_WORD -> {
                    dataCache.setCurrentState(userId, State.WAIT_FOR_MISSING_WORD);
                    return stateProcessor.phraseAnswerCheck(message);
                }
                case PHRASAL_VERBS -> {
                    dataCache.setCurrentState(userId, State.WAIT_FOR_MEANING);
                    return stateProcessor.phrasalProcess(message);
                }
                case WAIT_FOR_MEANING -> {
                    dataCache.setCurrentState(userId, State.WAIT_FOR_MEANING);
                    return stateProcessor.phrasalAnswerCheck(message);
                }
                case HELP -> {
                    dataCache.setCurrentState(userId, State.WAIT);
                    return stateProcessor.helpProcess(message);
                }
                case STOP -> {
                    dataCache.setCurrentState(userId, State.WAIT);
                    return stateProcessor.stopProcess(message);
                }
                case WAIT -> {
                    dataCache.setCurrentState(userId, State.WAIT);
                    return stateProcessor.waitProcess(message);
                }
                default -> {
                    dataCache.clearCacheInfo(userId);
                    dataCache.setCurrentState(userId, State.WAIT);
                    log.error(Constants.LOG_ERROR, MessageProcessorImpl.class);
                    return SendMessage.builder()
                            .chatId(String.valueOf(chatId))
                            .text(Constants.INTERNAL_ERROR)
                            .replyMarkup(Util.defaultKeyboard())
                            .build();
                }
            }
        } catch (Exception e) {
            dataCache.clearCacheInfo(userId);
            dataCache.setCurrentState(userId, State.WAIT);
            log.error(Constants.LOG_ERROR, MessageProcessorImpl.class, e);
            return SendMessage.builder()
                    .chatId(String.valueOf(chatId))
                    .text(Constants.INTERNAL_ERROR)
                    .replyMarkup(Util.defaultKeyboard())
                    .build();
        }
    }
}
