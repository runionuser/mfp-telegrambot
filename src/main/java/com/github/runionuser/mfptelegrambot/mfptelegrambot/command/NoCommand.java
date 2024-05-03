package com.github.runionuser.mfptelegrambot.mfptelegrambot.command;

import com.github.runionuser.mfptelegrambot.mfptelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class NoCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String NO_MESSAGE = "надо писать начиная со слеша(/).\n"
            + "чтобы посмотреть список команд пиши /help";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) throws TelegramApiException {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
