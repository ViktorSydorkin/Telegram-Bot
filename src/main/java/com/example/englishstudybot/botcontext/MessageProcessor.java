package com.example.englishstudybot.botcontext;

import com.example.englishstudybot.entity.State;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageProcessor {
    SendMessage process(State state, Message message);
}
