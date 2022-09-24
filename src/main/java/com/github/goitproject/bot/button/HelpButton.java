package com.github.goitproject.bot.button;

import com.github.goitproject.bot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpButton implements Button {
    private final SendMessageBotService sendMessageBotService;
    private final static String MESSAGE_HELP = "Help: \n" +
            "️  Get info - get the current exchange rate depending on the settings.\n\n" +
            "️  Settings - choice of currency, bank, accuracy and notification time\n\n" +
            "\uD83C\uDFAF   Number of decimal places - selection of course display accuracy (default 2)\n\n" +
            "\uD83C\uDFE6   Bank - bank selection (default NBU)\n\n" +
            "\uD83D\uDCB0   Currency - currency selection (USD by default)\n\n" +
            "  Notification time - select the time of notifications about the exchange rate according to the specified settings (default is 9:00)\n\n" +
            "\uD83D\uDD27   My settings - show current settings\n\n" +
            "   Turn off notifications\n";

    public HelpButton(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update, Settings settings) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageBotService.SendMessage(chatId, MESSAGE_HELP);
    }
}
