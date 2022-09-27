package com.github.goitproject.bot.button;

import com.github.goitproject.bot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.List;
import static com.github.goitproject.bot.button.enum_button.ButtonName.*;
import static com.github.goitproject.bot.button.enum_button.ButtonCallBack.*;

public class SettingsButton implements Button {
    private final static String BACK_EMOJI = "\u2B05\uFE0F";
    private final SendMessageBotService sendMessageBotService;
    private final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    private final InlineKeyboardButton button1 = new InlineKeyboardButton();
    private final InlineKeyboardButton button2 = new InlineKeyboardButton();
    private final InlineKeyboardButton button3 = new InlineKeyboardButton();
    private final InlineKeyboardButton button4 = new InlineKeyboardButton();

    private final InlineKeyboardButton button5 = new InlineKeyboardButton();

    List<InlineKeyboardButton> buttonsRow1 = new ArrayList<>();
    List<InlineKeyboardButton> buttonsRow2 = new ArrayList<>();

    List<InlineKeyboardButton> buttonsRow3 = new ArrayList<>();

    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    public SettingsButton(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update, Settings settings) {
        String chatId;
        if (update.hasMessage()) {
            chatId = update.getMessage().getChatId().toString();
        } else {
            chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        }
        buttonsRow1.clear();
        buttonsRow2.clear();
        buttonsRow3.clear();
        rowList.clear();
        sendMessageBotService.SendMessage(chatId, SETTINGS.getName(), createKeyBoard());
    }

    private ReplyKeyboard createKeyBoard() {
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
