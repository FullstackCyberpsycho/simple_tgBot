package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.List;

public class Main {
    public final static String BOT_TOKEN = "Токен бота";

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(BOT_TOKEN);
        telegramBot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> list) {
                for(Update update : list) {
                    SendMessage sendMessage = new SendMessage(update.message().from().id(), "Hello world!");
                    telegramBot.execute(sendMessage);
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });
    }
}