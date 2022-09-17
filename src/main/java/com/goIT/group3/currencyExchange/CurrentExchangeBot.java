package com.goIT.group3.currencyExchange;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class CurrentExchangeBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = new SendMessage();

        if (update.hasMessage() && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            message.setChatId(chat_id);
            String message_text = update.getMessage().getText();

            if (message_text.equals("/start")) {
                HandleStart(message);
            }
        } else if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            message.setChatId(chat_id);

            if (callbackData.equals("callback_chart")) {
                message.setText("You pressed 'Chart'");
            } else if (callbackData.equals("callback_calculator")) {
                message.setText("You pressed 'Calculator'");
            } else if (callbackData.equals("callback_rate")) {
                message.setText("You pressed 'Rate'");
            } else if (callbackData.equals("callback_settings")) {
                message.setText("You pressed 'Settings'");
            } else if (callbackData.equals("callback_help")) {
                message.setText("You pressed 'Help'");
            } else {
                message.setText("Error: Unknown callback data");
            }
        }

        try {
            execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "CurrentExchangeGroop3Bot";
    }

    @Override
    public String getBotToken() {
        return "5669881981:AAF5KxWgNsH39qJomfubgJx1TXpegCkdHAY";
    }

    private void HandleStart(SendMessage message)
    {
        message.setText("Welcome to Currency Exchange Bot!" +
                "Here you can get the latest updates on currency exchanges," +
                "as well as charts for selected currency pairs.");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();

        InlineKeyboardButton inlineButton1 = new InlineKeyboardButton();
        inlineButton1.setText("Chart");
        inlineButton1.setCallbackData("callback_chart");
        buttonRow1.add(inlineButton1);

        InlineKeyboardButton inlineButton2 = new InlineKeyboardButton();
        inlineButton2.setText("Calculator");
        inlineButton2.setCallbackData("callback_calculator");
        buttonRow1.add(inlineButton2);

        InlineKeyboardButton inlineButton3 = new InlineKeyboardButton();
        inlineButton3.setText("Rate");
        inlineButton3.setCallbackData("callback_rate");
        buttonRow1.add(inlineButton3);

        InlineKeyboardButton inlineButton4 = new InlineKeyboardButton();
        inlineButton4.setText("Settings");
        inlineButton4.setCallbackData("callback_settings");
        buttonRow2.add(inlineButton4);

        InlineKeyboardButton inlineButton5 = new InlineKeyboardButton();
        inlineButton5.setText("Help");
        inlineButton5.setCallbackData("callback_help");
        buttonRow2.add(inlineButton5);

        keyboard.add(buttonRow1);
        keyboard.add(buttonRow2);
        markup.setKeyboard(keyboard);
        message.setReplyMarkup(markup);
    }
}
