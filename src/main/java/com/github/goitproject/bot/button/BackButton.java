package com.github.goitproject.bot.button;

import com.github.goitproject.bot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.List;

import static com.github.goitproject.bot.button.enum_button.ButtonName.*;
import static com.github.goitproject.bot.button.enum_button.ButtonCallBack.*;

public class BackButton implements Button {
    private final SendMessageBotService sendMessageBotService;
    private final static String BACK_EMOJI = "\u2B05\uFE0F";
    private final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    InlineKeyboardButton button1 = new InlineKeyboardButton();
    InlineKeyboardButton button2 = new InlineKeyboardButton();
    InlineKeyboardButton button3 = new InlineKeyboardButton();
    InlineKeyboardButton button4 = new InlineKeyboardButton();
    InlineKeyboardButton button5 = new InlineKeyboardButton();

    List<InlineKeyboardButton> buttonsRow1 = new ArrayList<>();
    List<InlineKeyboardButton> buttonsRow2 = new ArrayList<>();
    List<InlineKeyboardButton> buttonsRow3 = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    public BackButton(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update, Settings settings) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
        buttonsRow1.clear();
        buttonsRow2.clear();
        buttonsRow3.clear();
        rowList.clear();
        sendMessageBotService.EditMessage(chatId, messageId, SETTINGS.getName(), backToSettings());
    }

    private InlineKeyboardMarkup backToSettings() {
        button1.setText(PRECISION.getName());
        button1.setCallbackData(PRECISION_CALLBACK.getCallback());

        button2.setText(BANK.getName());
        button2.setCallbackData(BANK_CALLBACK.getCallback());

        button3.setText(CURRENCY.getName());
        button3.setCallbackData(CURRENCY_CALLBACK.getCallback());

        button4.setText(TIME_UPDATE.getName());
        button4.setCallbackData(TIME_UPDATE_CALLBACK.getCallback());

        button5.setText(BACK_EMOJI+BACK_TO_START.getName());
        button5.setCallbackData(BACK_TO_START_CALLBACK.getCallback());

        buttonsRow1.add(button1);
        buttonsRow1.add(button2);
        buttonsRow2.add(button3);
        buttonsRow2.add(button4);
        buttonsRow3.add(button5);

        rowList.add(buttonsRow1);
        rowList.add(buttonsRow2);
        rowList.add(buttonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
}
