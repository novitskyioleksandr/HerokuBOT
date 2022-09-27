package com.github.goitproject.bot.service.timer;

import com.github.goitproject.bot.TelegramBot;
import com.github.goitproject.bot.button.GetMessageInfo;
import com.github.goitproject.bot.button.Settings;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.time.LocalTime;
import java.util.*;

import static com.github.goitproject.bot.button.enum_button.ButtonName.*;

public class Task extends TimerTask {
    private final TelegramBot telegramBot;
    private final GetMessageInfo getMessage = new GetMessageInfo();

    public Task(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Override
    public void run() {
        SendMessage sendMessage = new SendMessage();
        StringBuilder message = new StringBuilder();
        Map<Long, Settings> settings = telegramBot.getSettings();
        if (settings.size() == 0)
            return;
        List<Settings> toListSettings = new ArrayList<>(settings.values());
        for (Settings st : toListSettings) {
            if (!st.isCheckDisableTimeUpdate()) {
                String timeUpdate = st.getTimeUpdate();
                if (timeUpdate.substring(0, timeUpdate.indexOf(':'))
                        .equals(String.valueOf(LocalTime.now().getHour()))) {
                    Long chatId = st.getChatId();
                    sendMessage.setChatId(chatId.toString());
                    if (st.isCheckNBU()) {
                        message.append(getMessage.getMessageInfo(NBU, st));
                    }
                    if (st.isCheckMonoBank()) {
                        message.append(getMessage.getMessageInfo(MONOBANK, st));
                    }
                    if (st.isCheckPrivatBank()) {
                        message.append(getMessage.getMessageInfo(PRIVATBANK, st));
                    }
                    sendMessage.setText(message.toString());
                    try {
                        telegramBot.execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    message.delete(0, message.length());
                }
            }
        }
    }
}