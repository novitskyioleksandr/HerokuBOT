package com.github.goitproject.bot.button;

import com.github.goitproject.bot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.List;
import static com.github.goitproject.bot.button.enum_button.ButtonCallBack.*;
import static com.github.goitproject.bot.button.enum_button.ButtonName.*;

public class CurrencyButton implements Button {
    private final SendMessageBotService sendMessageBotService;
    private static String data;
    private Settings settings;
    private final static String MESSAGE = "\uD83D\uDCB0 Виберіть валюту";
    private final static String CHECK = "\u2705";
    private final static String UNCHECK = "";
    private final static String BACK_EMOJI = "\u2B05\uFE0F";

    private final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    private final InlineKeyboardButton buttonUSD = new InlineKeyboardButton();
    private final InlineKeyboardButton buttonEUR = new InlineKeyboardButton();
    private final InlineKeyboardButton buttonCZK = new InlineKeyboardButton();
    private final InlineKeyboardButton buttonPLN = new InlineKeyboardButton();
    private final InlineKeyboardButton buttonGBP = new InlineKeyboardButton();
    private final InlineKeyboardButton buttonBack = new InlineKeyboardButton();
    private final List<InlineKeyboardButton> buttonsRow1 = new ArrayList<>();
    private final List<InlineKeyboardButton> buttonsRow2 = new ArrayList<>();
    private final List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    public CurrencyButton(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update, Settings settings) {
        this.settings = settings;
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
        data = update.getCallbackQuery().getData();
        if (data.equals(CURRENCY_CALLBACK.getCallback())) {
            buttonsRow1.clear();
            buttonsRow2.clear();
            rowList.clear();
            sendMessageBotService.EditMessage(chatId, messageId, MESSAGE, createKeyBoard());
        } else {
            sendMessageBotService.EditMessage(chatId, messageId, MESSAGE, editKeyBoard());
        }
    }

    private InlineKeyboardMarkup createKeyBoard() {

        if (settings.isCheckUSD()) {
            buttonUSD.setText(CHECK + USD.getName());
        } else {
            buttonUSD.setText(UNCHECK + USD.getName());
        }
        buttonUSD.setCallbackData(USD_CALLBACK.getCallback());

        if (settings.isCheckEUR()) {
            buttonEUR.setText(CHECK + EUR.getName());
        } else {
            buttonEUR.setText(UNCHECK + EUR.getName());
        }
        buttonEUR.setCallbackData(EUR_CALLBACK.getCallback());

        if (settings.isCheckCZK()) {
            buttonCZK.setText(CHECK + CZK.getName());
        } else {
            buttonCZK.setText(UNCHECK + CZK.getName());
        }
        buttonCZK.setCallbackData(CZK_CALLBACK.getCallback());

        if (settings.isCheckPLN()) {
            buttonPLN.setText(CHECK + PLN.getName());
        } else {
            buttonPLN.setText(UNCHECK + PLN.getName());
        }
        buttonPLN.setCallbackData(PLN_CALLBACK.getCallback());

        if (settings.isCheckGBP()) {
            buttonGBP.setText(CHECK + GBP.getName());
        } else {
            buttonGBP.setText(UNCHECK + GBP.getName());
        }
        buttonGBP.setCallbackData(GBP_CALLBACK.getCallback());

        buttonBack.setText(BACK_EMOJI + BACK.getName());
        buttonBack.setCallbackData(BACK_CALLBACK.getCallback());

        buttonsRow1.add(buttonUSD);
        buttonsRow1.add(buttonEUR);
        buttonsRow1.add(buttonCZK);
        buttonsRow1.add(buttonPLN);
        buttonsRow1.add(buttonGBP);

        buttonsRow2.add(buttonBack);

        rowList.add(buttonsRow1);
        rowList.add(buttonsRow2);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }

    private InlineKeyboardMarkup editKeyBoard() {
        if (data.equals(USD_CALLBACK.getCallback())) {
            if (settings.isCheckUSD()) {
                buttonUSD.setText(UNCHECK + USD.getName());
                settings.setCheckUSD(false);
            } else {
                buttonUSD.setText(CHECK + USD.getName());
                settings.setCheckUSD(true);
            }
        }
        if (data.equals(EUR_CALLBACK.getCallback())) {
            if (settings.isCheckEUR()) {
                buttonEUR.setText(UNCHECK + EUR.getName());
                settings.setCheckEUR(false);
            } else {
                buttonEUR.setText(CHECK + EUR.getName());
                settings.setCheckEUR(true);
            }
        }
        if (data.equals(CZK_CALLBACK.getCallback())) {
            if (settings.isCheckCZK()) {
                buttonCZK.setText(UNCHECK + CZK.getName());
                settings.setCheckCZK(false);
            } else {
                buttonCZK.setText(CHECK + CZK.getName());
                settings.setCheckCZK(true);
            }
        }
        if (data.equals(PLN_CALLBACK.getCallback())) {
            if (settings.isCheckPLN()) {
                buttonPLN.setText(UNCHECK + PLN.getName());
                settings.setCheckPLN(false);
            } else {
                buttonPLN.setText(CHECK + PLN.getName());
                settings.setCheckPLN(true);
            }
        }
        if (data.equals(GBP_CALLBACK.getCallback())) {
            if (settings.isCheckGBP()) {
                buttonGBP.setText(UNCHECK + GBP.getName());
                settings.setCheckGBP(false);
            } else {
                buttonGBP.setText(CHECK + GBP.getName());
                settings.setCheckGBP(true);
            }
        }
        return inlineKeyboardMarkup;
    }
}
