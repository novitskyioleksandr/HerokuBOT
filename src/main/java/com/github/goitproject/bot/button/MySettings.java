package com.github.goitproject.bot.button;

import com.github.goitproject.bot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MySettings implements Button {
    private final SendMessageBotService sendMessageBotService;

    public MySettings(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update, Settings settings) {
        String chatId = update.getMessage().getChatId().toString();
        StringBuilder message = new StringBuilder();
        message.append("\uD83D\uDD27  My settings: \n");
        message.append("Bank: ");
        if (settings.isCheckNBU())
            message.append("NBU ");
        if (settings.isCheckMonoBank())
            message.append("Monobank ");
        if (settings.isCheckPrivatBank())
            message.append("Privatbank ");

        message.append("\n");

        message.append("Currency: ");
        if (settings.isCheckUSD())
            message.append("USD ");
        if (settings.isCheckEUR())
            message.append("EUR ");
        if (settings.isCheckCZK())
            message.append("CZK ");
        if (settings.isCheckPLN())
            message.append("PLN ");
        if (settings.isCheckGBP())
            message.append("GBP ");
        message.append("\n");
        message.append("Number of decimal places: ");

        switch (settings.getPrecision()) {
            case 2:
                message.append("2\n");
                break;
            case 3:
                message.append("3\n");
                break;
            case 4:
                message.append("4\n");
        }
        message.append("Notification time:  ");
        if (!settings.isCheckDisableTimeUpdate()) {
            switch (settings.getTimeUpdate()) {
                case "6:00":
                    message.append("6:00\n");
                    break;
                case "7:00":
                    message.append("7:00\n");
                    break;
                case "8:00":
                    message.append("8:00\n");
                    break;
                case "9:00":
                    message.append("9:00\n");
                    break;
                case "10:00":
                    message.append("10:00\n");
                    break;
                case "11:00":
                    message.append("11:00\n");
                    break;
                case "12:00":
                    message.append("12:00\n");
                    break;
                case "13:00":
                    message.append("13:00\n");
                    break;
                case "14:00":
                    message.append("14:00\n");
                    break;
                case "15:00":
                    message.append("15:00\n");
                    break;
                case "16:00":
                    message.append("16:00\n");
                    break;
                case "17:00":
                    message.append("17:00\n");
                    break;
                case "18:00":
                    message.append("18:00\n");
                    break;
                case "19:00":
                    message.append("19:00\n");
                    break;
                case "20:00":
                    message.append("20:00\n");
                    break;
                case "21:00":
                    message.append("21:00\n");
                    break;
                case "Notifications turned off":
                    message.append("Notifications turned off\n");
                    break;
            }
        } else
            message.append("Turn off\n");
        sendMessageBotService.SendMessage(chatId, message.toString());
    }
}
