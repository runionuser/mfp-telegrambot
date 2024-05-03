package com.github.runionuser.mfptelegrambot.mfptelegrambot.bot;

import com.github.runionuser.mfptelegrambot.mfptelegrambot.command.CommandContainer;
import com.github.runionuser.mfptelegrambot.mfptelegrambot.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

import static com.github.runionuser.mfptelegrambot.mfptelegrambot.command.CommandName.NO;

@Component
public class MFPTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    @Autowired
    public MFPTelegramBot(List<String> admins) {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), admins);
    }

    @Override
        public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            boolean isMessageCommand = update.getMessage().isCommand();
            String username = update.getMessage().getFrom().getUserName();
            if (isMessageCommand) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                try {
                    commandContainer.findCommand(commandIdentifier, username).execute(update);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    commandContainer.findCommand(NO.getCommandName(), username).execute(update);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
