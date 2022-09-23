package com.github.goitproject.bot;

import com.github.goitproject.bot.button.ButtonContainer;
import com.github.goitproject.bot.button.Settings;
import com.github.goitproject.bot.service.SendMessageBotService;
import com.github.goitproject.bot.service.timer.TimeUpdate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;


public class TelegramBot extends TelegramLongPollingBot {
    private final ButtonContainer buttonContainer;
    private static final String BOT_USER_NAME = "ABC_param_pam_pam_bot";
    private static final String TOKEN = "5756654112:AAF26mht200qU2Esn9TsHuRkIbnMQIMGoNc";

    public TelegramBot() {
        this.buttonContainer = new ButtonContainer(new SendMessageBotService(this));
        TimeUpdate timeUpdate = new TimeUpdate(this);
        timeUpdate.startTimer();
    }

    @Override
    public String getBotUsername() {
        return BOT_USER_NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        String buttonIdentifier;
        Long chatId;
        if (update.hasMessage()) {
            buttonIdentifier = update.getMessage().getText().trim();
            chatId = update.getMessage().getChatId();
            buttonContainer.retrieveButton(buttonIdentifier).execute(update, buttonContainer.getSettingsCurrentUser(chatId));
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            buttonIdentifier = update.getCallbackQuery().getData();
            buttonContainer.retrieveButton(buttonIdentifier).execute(update, buttonContainer.getSettingsCurrentUser(chatId));
        }
    }

    public Map<Long, Settings> getSettings() {
        return buttonContainer.getAlUserSettings();
    }
}
