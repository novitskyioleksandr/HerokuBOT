package com.github.goitproject.bot.button;

import com.github.goitproject.bot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.ArrayList;
import java.util.List;
import static com.github.goitproject.bot.button.enum_button.ButtonCallBack.INFO_CALLBACK;
import static com.github.goitproject.bot.button.enum_button.ButtonCallBack.SETTINGS_CALLBACK;
import static com.github.goitproject.bot.button.enum_button.ButtonName.INFO;
import static com.github.goitproject.bot.button.enum_button.ButtonName.SETTINGS;

public class BackToStartButton implements Button {

    private final SendMessageBotService sendMessageBotService;
    public final static String START_MESSAGE = "Привіт, %s. Цей бот допоможе відслідковувати актуальні курси валют.";
    private final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    InlineKeyboardButton button1 = new InlineKeyboardButton();
    InlineKeyboardButton button2 = new InlineKeyboardButton();
    List<InlineKeyboardButton> buttonsRow1 = new ArrayList<>();
    List<InlineKeyboardButton> buttonsRow2 = new ArrayList<>();
    List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

    public BackToStartButton(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }


    @Override
    public void execute(Update update, Settings settings) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        Integer messageId = update.getCallbackQuery().getMessage().getMessageId();
        String firstname = update.getCallbackQuery().getFrom().getFirstName();
        buttonsRow1.clear();
        buttonsRow2.clear();
        rowList.clear();
        sendMessageBotService.EditMessage(chatId, messageId, String.format(START_MESSAGE, firstname), backToStart());
    }

    private InlineKeyboardMarkup backToStart() {
        button1.setText(INFO.getName());
        button2.setText(SETTINGS.getName());
        button1.setCallbackData(INFO_CALLBACK.getCallback());
        button2.setCallbackData(SETTINGS_CALLBACK.getCallback());
        buttonsRow1.add(button1);
        buttonsRow2.add(button2);
        rowList.add(buttonsRow1);
        rowList.add(buttonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
}
