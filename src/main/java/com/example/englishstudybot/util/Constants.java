package com.example.englishstudybot.util;

public interface Constants {
    String START = "You have just started your conversation with the English Study Bot!";
    String HELP = "If you want to start your studying - just press the \"/study\" menu button." +
            "\n\nNow you should choose one of the three types of the studying:" +
            "\n - Vocabulary. You will have an english word to translate with 4 answers. Only 1 answer is correct. After entering the wrong answer" +
            "\n - Phrases. You will get the phrase with one missing word. You will have to choose the right missing word. You will have 4 options. Only 1 answer is correct. After entering the wrong answer" +
            "\n - Phrasal verbs. You will see meanings of the exact phrasal verb. You will have to choose the right one. You will have 4 options. Only 1 answer is correct. After entering the wrong answer" +
            " you will be able to try again with less amount of options." +
            "\n\nPress \"/stop\" to stop the study process";
    String STOP = "You have stopped your studying";
    String WAIT = "Use one of the commands below";
    String CHOOSE_THE_TRANSLATION = "Choose the correct translation of the word:";
    String CHOOSE_THE_PREPOSITION = "Choose the correct preposition:";
    String CHOOSE_THE_VERB = "Choose the correct phrasal verb for these meanings:";
    String STOP_COMMAND = " - stop your studying";
    String STUDY_COMMAND = " - start the studying";
    String HELP_COMMAND = " - see the help message";
    String INCORRECT = "Incorrect! Try again!";
    String INTERNAL_ERROR = "Internal error occurred";
    String INPUT_ERROR = "You should enter only text!";
    String COMMAND_STOP = "/stop";
    String COMMAND_START = "/start";
    String COMMAND_STUDY = "/study";
    String COMMAND_HELP = "/help";
    String VOCABULARY = "Vocabulary";
    String PHRASAL_VERBS = "Phrasal verbs";
    String PHRASES = "Phrases";
    String LOG_ERROR = "Error occurred at {}";
}
