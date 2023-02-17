package com.example.englishstudybot.bot;

import com.example.englishstudybot.botcontext.MessageProcessor;
import com.example.englishstudybot.cache.DataCache;
import com.example.englishstudybot.config.BotConfig;
import com.example.englishstudybot.entity.State;
import com.example.englishstudybot.util.Constants;
import com.example.englishstudybot.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
@Component
public class Bot extends TelegramLongPollingBot {
    @Autowired
    BotConfig config;
    @Autowired
    private DataCache dataCache;
    @Autowired
    private MessageProcessor messageProcessor;
    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        long userId = update.getMessage().getFrom().getId();
        State state;
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            switch (message) {
                case Constants.COMMAND_START -> state = State.START;
                case Constants.COMMAND_HELP -> state = State.HELP;
                case Constants.COMMAND_STUDY -> state = State.STUDY;
                case Constants.COMMAND_STOP -> state = State.STOP;
                case Constants.VOCABULARY -> state = State.WORDS;
                case Constants.PHRASES -> state = State.PHRASES;
                case Constants.PHRASAL_VERBS -> state = State.PHRASAL_VERBS;
                default -> state = dataCache.getCurrentState(userId);
            }
            dataCache.setCurrentState(userId, state);
            Util.sendMessage(messageProcessor.process(state, update.getMessage()), this);
        } else {
            Util.sendMessage(new SendMessage(String.valueOf(chatId), Constants.INPUT_ERROR), this);
        }
    }
}
