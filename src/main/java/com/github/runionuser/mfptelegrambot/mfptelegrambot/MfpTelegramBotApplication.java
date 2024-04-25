package com.github.runionuser.mfptelegrambot.mfptelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MfpTelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(MfpTelegramBotApplication.class, args);
    }

}
