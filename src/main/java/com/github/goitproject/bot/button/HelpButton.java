package com.github.goitproject.bot.button;

import com.github.goitproject.bot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpButton implements Button {
    private final SendMessageBotService sendMessageBotService;
    private final static String MESSAGE_HELP = "Help: \n" +

            "️   Отримати інформацю - отримати поточний курс обміну в залежності від налаштувань.\n\n" +
            "️   Налаштування - вибір валюти, банку, точності та часу повідомлення\n\n" +
            "\uD83C\uDFAF   Кількість знаків після коми - вибір точності відображення курсу (за замовчуванням 2)\n\n" +
            "\uD83C\uDFE6   Банк - вибір банку (за замовчуванням НБУ)\n\n" +
            "\uD83D\uDCB0   Валюта - вибір валюти (USD за замовчуванням)\n\n" +
            "     Час повідомлень - виберіть час повідомлень про курс валют відповідно до заданих налаштувань (за замовчуванням 9:00) \n\n" +
            "\uD83D\uDD27   Мої налаштування - показати поточні налаштування \n\n" +
            "     Вимкніть сповіщення \n";

    public HelpButton(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update, Settings settings) {
        String chatId = update.getMessage().getChatId().toString();
        sendMessageBotService.SendMessage(chatId, MESSAGE_HELP);
    }
}
