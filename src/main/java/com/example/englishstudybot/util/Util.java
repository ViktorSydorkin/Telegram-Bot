package com.example.englishstudybot.util;

import com.example.englishstudybot.cache.DataCache;
import com.example.englishstudybot.entity.Answer;
import com.example.englishstudybot.entity.Phrasal;
import com.example.englishstudybot.entity.Preposition;
import com.example.englishstudybot.entity.Word;
import com.vdurmont.emoji.EmojiParser;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public abstract class Util {
    public static void sendMessage(SendMessage sendMessage, TelegramLongPollingBot bot) {
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.error(Constants.LOG_ERROR + e.getMessage(), e);
        }
    }

    public static ReplyKeyboardMarkup defaultKeyboard() {
        return getReplyKeyboardMarkup(Constants.COMMAND_HELP, Constants.COMMAND_STUDY);
    }

    public static ReplyKeyboardMarkup studyAskKeyboard() {
        return getReplyKeyboardMarkup(Constants.VOCABULARY, Constants.PHRASES, Constants.PHRASAL_VERBS);
    }

    private static ReplyKeyboardMarkup getReplyKeyboardMarkup(String... commands) {
        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        for (int i = 0; i < commands.length; i++) {
            row.add(commands[i]);
        }
        rows.add(row);
        return ReplyKeyboardMarkup.builder()
                .keyboard(rows)
                .oneTimeKeyboard(true)
                .resizeKeyboard(true)
                .build();
    }

    public static SendMessage createWordsKeyboard(Message message, DataCache dataCache, List<Word> words, Answer answer) {
        long userId = message.getFrom().getId();
        String part = "";
        if (answer == Answer.INCORRECT)
            part = EmojiParser.parseToUnicode(":x:" + Constants.INCORRECT + "\n");
        String botAnswer = EmojiParser.parseToUnicode(part + ":grey_question:" + " " + Constants.CHOOSE_THE_TRANSLATION);
        List<KeyboardRow> rows = new ArrayList<>(2);
        int rowAmount = (int) Math.round(words.size() / 2.0);
        for (int i = 0, k = 0; i < rowAmount; i++, k += 2) {
            KeyboardRow keyboardRow = new KeyboardRow(2);
            keyboardRow.add(words.get(k).getUkrainianWord());
            if (k != words.size() - 1) keyboardRow.add(words.get(k + 1).getUkrainianWord());
            rows.add(keyboardRow);
        }
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(botAnswer + " " + dataCache.getCacheInfo(userId).getWord().getEnglishWord())
                .replyMarkup(ReplyKeyboardMarkup.builder()
                        .resizeKeyboard(true)
                        .keyboard(rows)
                        .build())
                .build();
    }

    public static SendMessage createPhrasesKeyboard(Message message, DataCache dataCache, List<Preposition> prepositions, Answer answer) {
        long userId = message.getFrom().getId();
        String part = "";
        if (answer == Answer.INCORRECT)
            part = EmojiParser.parseToUnicode(":x:" + Constants.INCORRECT + "\n");
        String botAnswer = EmojiParser.parseToUnicode(part + ":grey_question:" + " " + Constants.CHOOSE_THE_PREPOSITION);
        List<KeyboardRow> rows = new ArrayList<>(2);
        int rowAmount = (int) Math.round(prepositions.size() / 2.0);
        for (int i = 0, k = 0; i < rowAmount; i++, k += 2) {
            KeyboardRow keyboardRow = new KeyboardRow(2);
            keyboardRow.add(prepositions.get(k).getPreposition());
            if (k != prepositions.size() - 1) keyboardRow.add(prepositions.get(k + 1).getPreposition());
            rows.add(keyboardRow);
        }
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(botAnswer + " " + dataCache.getCacheInfo(userId).getPhrase().getPhrase())
                .replyMarkup(ReplyKeyboardMarkup.builder()
                        .resizeKeyboard(true)
                        .keyboard(rows)
                        .build())
                .build();
    }

    public static SendMessage createPhrasalKeyboard(Message message, DataCache dataCache, List<Phrasal> phrasalVerbs, Answer answer) {
        long userId = message.getFrom().getId();
        String part = "";
        if (answer == Answer.INCORRECT)
            part = EmojiParser.parseToUnicode(":x:" + Constants.INCORRECT + "\n");
        String botAnswer = EmojiParser.parseToUnicode(part + ":grey_question:" + " " + Constants.CHOOSE_THE_VERB);
        List<KeyboardRow> rows = new ArrayList<>(2);
        int rowAmount = (int) Math.round(phrasalVerbs.size() / 2.0);
        for (int i = 0, k = 0; i < rowAmount; i++, k += 2) {
            KeyboardRow keyboardRow = new KeyboardRow(2);
            keyboardRow.add(phrasalVerbs.get(k).getPhrasalVerb());
            if (k != phrasalVerbs.size() - 1) keyboardRow.add(phrasalVerbs.get(k + 1).getPhrasalVerb());
            rows.add(keyboardRow);
        }
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(botAnswer + " " + dataCache.getCacheInfo(userId).getPhrasalVerb().getMeanings())
                .replyMarkup(ReplyKeyboardMarkup.builder()
                        .resizeKeyboard(true)
                        .keyboard(rows)
                        .build())
                .build();
    }


    public static List<Long> randomArray(long wordAmount, int size) {
        List<Long> longs = new ArrayList<>(4);
        SecureRandom  random = new SecureRandom();
        longs.add(random.nextLong(wordAmount) + 1);
        for (int i = 1; i < size; i++) {
            long temp = random.nextLong(wordAmount) + 1;
            if (longs.contains(temp)) {
                i--;
                continue;
            }
            longs.add(temp);
        }
        return longs;
    }
}
