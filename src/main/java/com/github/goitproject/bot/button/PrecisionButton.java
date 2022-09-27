package com.github.goitproject.bot.button;

import com.github.goitproject.bot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.List;
import static com.github.goitproject.bot.button.enum_button.ButtonName.*;
import static com.github.goitproject.bot.button.enum_button.ButtonCallBack.*;

public class PrecisionButton implements Button {
    private final SendMessageBotService sendMessageBotService;
    private static String data;
    private Settings settings;
    private final static String MESSAGE = "\uD83C\uDFAF Виберіть кількість знаків після коми";
    private final static String CHECK = "\u2705";
    private final static String UNCHECK = "";
    private final static String BACK_EMOJI = "\u2B05\uFE0F";


    private final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    private final InlineKeyboardButton buttonTWO = new InlineKeyboardButton();
    private final InlineKeyboardButton buttonTHREE = new InlineKeyboardButton();
    private final InlineKeyboardButton buttonFOUR = new InlineKeyboardButton();
    private final InlineKeyboardButton buttonBack = new InlineKeyboardButton();

    private final List<InlineKeyboardButton> buttonsRow1 = new ArrayList<>();
    private final List<InlineKeyboardButton> buttonsRow2 = new ArrayList<>();

    private final List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    public PrecisionButton(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update, Settings settings) {
        this.settings = settings;

        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
        data = update.getCallbackQuery().getData();
        if (data.equals(PRECISION_CALLBACK.getCallback())) {
            buttonsRow1.clear();
            buttonsRow2.clear();

            rowList.clear();
            sendMessageBotService.EditMessage(chatId, messageId, MESSAGE, createKeyBoard());
        } else if ((data.equals(PRECISION_TWO_CALLBACK.getCallback()) && settings.getPrecision() != 2) ||
                (data.equals(PRECISION_THREE_CALLBACK.getCallback()) && settings.getPrecision() != 3) ||
                (data.equals(PRECISION_FOUR_CALLBACK.getCallback()) && settings.getPrecision() != 4)) {
            sendMessageBotService.EditMessage(chatId, messageId, MESSAGE, editKeyBoard());
        }
    }

    private InlineKeyboardMarkup createKeyBoard() {

        switch (settings.getPrecision()) {
            case 2:
                buttonTWO.setText(CHECK + PRECISION_TWO.getName());
                buttonTHREE.setText(UNCHECK + PRECISION_THREE.getName());
                buttonFOUR.setText(UNCHECK + PRECISION_FOUR.getName());
                break;
            case 3:
                buttonTWO.setText(UNCHECK + PRECISION_TWO.getName());
                buttonTHREE.setText(CHECK + PRECISION_THREE.getName());
                buttonFOUR.setText(UNCHECK + PRECISION_FOUR.getName());
                break;
            case 4:
                buttonTWO.setText(UNCHECK + PRECISION_TWO.getName());
                buttonTHREE.setText(UNCHECK + PRECISION_THREE.getName());
                buttonFOUR.setText(CHECK + PRECISION_FOUR.getName());
                break;
        }
        buttonBack.setText(BACK_EMOJI + BACK.getName());
        buttonBack.setCallbackData(BACK_CALLBACK.getCallback());

        buttonTWO.setCallbackData(PRECISION_TWO_CALLBACK.getCallback());
        buttonTHREE.setCallbackData(PRECISION_THREE_CALLBACK.getCallback());
        buttonFOUR.setCallbackData(PRECISION_FOUR_CALLBACK.getCallback());

        buttonsRow1.add(buttonTWO);
        buttonsRow1.add(buttonTHREE);
        buttonsRow1.add(buttonFOUR);
        buttonsRow2.add(buttonBack);

        rowList.add(buttonsRow1);
        rowList.add(buttonsRow2);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private InlineKeyboardMarkup editKeyBoard() {
        if (data.equals(PRECISION_TWO_CALLBACK.getCallback())) {
            buttonTWO.setText(CHECK + PRECISION_TWO.getName());
            buttonTHREE.setText(UNCHECK + PRECISION_THREE.getName());
            buttonFOUR.setText(UNCHECK + PRECISION_FOUR.getName());
            settings.setPrecision(2);
        }
        if (data.equals(PRECISION_THREE_CALLBACK.getCallback())) {
            buttonTWO.setText(UNCHECK + PRECISION_TWO_CALLBACK.getCallback());
            buttonTHREE.setText(CHECK + PRECISION_THREE_CALLBACK.getCallback());
            buttonFOUR.setText(UNCHECK + PRECISION_FOUR_CALLBACK.getCallback());
            settings.setPrecision(3);
        }
        if (data.equals(PRECISION_FOUR_CALLBACK.getCallback())) {
            buttonTWO.setText(UNCHECK + PRECISION_TWO.getName());
            buttonTHREE.setText(UNCHECK + PRECISION_THREE.getName());
            buttonFOUR.setText(CHECK + PRECISION_FOUR.getName());
            settings.setPrecision(4);
        }
        return inlineKeyboardMarkup;
    }
}
