package com.github.runionuser.mfptelegrambot.mfptelegrambot.service;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message) throws TelegramApiException;
}
