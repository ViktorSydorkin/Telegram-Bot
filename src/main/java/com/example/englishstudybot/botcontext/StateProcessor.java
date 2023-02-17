package com.example.englishstudybot.botcontext;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface StateProcessor {
    SendMessage helpProcess(Message message);
    SendMessage wordProcess(Message message);
    SendMessage studyProcess(Message message);
    SendMessage phraseProcess(Message message);
    SendMessage startProcess(Message message);
    SendMessage wordAnswerCheck(Message message);
    SendMessage phraseAnswerCheck(Message message);
    SendMessage phrasalProcess(Message message);
    SendMessage phrasalAnswerCheck(Message message);
    SendMessage stopProcess(Message message);
    SendMessage waitProcess(Message message);
}
