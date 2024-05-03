package com.github.runionuser.mfptelegrambot.mfptelegrambot.command;

import com.github.runionuser.mfptelegrambot.mfptelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.runionuser.mfptelegrambot.mfptelegrambot.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("я знаю только команды:\n\n"
            + "%s начнем общение\n"
            + "%s закончим общение\n"
            + "%s попросить помощи\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) throws TelegramApiException {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
