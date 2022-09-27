package com.github.goitproject.bot.service.timer;

import com.github.goitproject.bot.TelegramBot;

import java.time.LocalTime;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TimeUpdate {

    private final Timer timer;
    private final Task task;
    private static final long ONE_HOUR = 3600000L;

    public TimeUpdate(TelegramBot telegramBot) {
        this.timer = new Timer();
        task = new Task(telegramBot);
    }

    public void startTimer() {
        int currentMinute = LocalTime.now().getMinute();
        int currentSecond = LocalTime.now().getSecond();

        if(currentMinute != 0 && currentSecond != 0) {
           long delay =  TimeUnit.MINUTES.toMillis(60) - TimeUnit.MINUTES.toMillis(currentMinute) - TimeUnit.SECONDS.toMillis(currentSecond);
            timer.schedule(task, delay, ONE_HOUR);
        }
        else {
            timer.schedule(task, 0, ONE_HOUR);
        }
    }
}
