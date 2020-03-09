package 状态;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BotContextTest {
    BotContext bot;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        bot = new BotContext();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        bot = null;
    }

    @org.junit.jupiter.api.Test
    void chat() {
        System.out.print("> ");
        String input = "hello";
        String output = bot.chat(input);
        System.out.println(output.isEmpty() ? "(no reply)" : "< " + output);
    }
}