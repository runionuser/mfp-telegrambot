package com.github.runionuser.mfptelegrambot.mfptelegrambot.service;

import com.github.runionuser.mfptelegrambot.mfptelegrambot.bot.MFPTelegramBot;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final MFPTelegramBot mfpTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(MFPTelegramBot mfpTelegramBot) {
        this.mfpTelegramBot = mfpTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);
        mfpTelegramBot.execute(sendMessage);
    }


}
