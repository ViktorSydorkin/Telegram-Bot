package com.example.englishstudybot.config;

import com.example.englishstudybot.util.Constants;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

@Configuration
@Data
public class BotConfig {
    @Value("${bot.name}")
    String name;
    @Value("${bot.token}")
    String token;

    @Bean
    BotCommand helpCommand() {
        return new BotCommand(Constants.COMMAND_HELP, Constants.HELP_COMMAND);
    }

    @Bean
    BotCommand studyCommand() {
        return new BotCommand(Constants.COMMAND_STUDY, Constants.STUDY_COMMAND);
    }

    @Bean
    BotCommand stopCommand() {
        return new BotCommand(Constants.COMMAND_STOP, Constants.STOP_COMMAND);
    }
}
