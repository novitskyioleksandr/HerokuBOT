package com.github.goitproject.bot.button;

public class Settings {

    private boolean isCheckUSD;
    private boolean isCheckEUR;
    private boolean isCheckCZK;
    private boolean isCheckPLN;
    private boolean isCheckGBP;
    private boolean isCheckMonoBank;
    private boolean isCheckPrivatBank;
    private boolean isCheckNBU;
    private String TimeUpdate;
    private boolean isCheckDisableTimeUpdate;
    private Integer precision;
    private Long chatId;

    public Settings(Long chatId) {
        this.chatId = chatId;
        isCheckUSD = true;
        isCheckEUR = false;
        isCheckCZK = false;
        isCheckPLN = false;
        isCheckGBP = false;

        isCheckMonoBank = false;
        isCheckPrivatBank = false;
        isCheckNBU = true;
        TimeUpdate = "9:00";
        isCheckDisableTimeUpdate = true;
        precision = 2;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getChatId() {
        return chatId;
    }

    public boolean isCheckUSD() {
        return isCheckUSD;
    }

    public void setCheckUSD(boolean checkUSD) {
        isCheckUSD = checkUSD;
    }

    public boolean isCheckEUR() {
        return isCheckEUR;
    }

    public void setCheckEUR(boolean checkEUR) {
        isCheckEUR = checkEUR;
    }

    public boolean isCheckCZK() {
        return isCheckCZK;
    }

    public void setCheckCZK(boolean checkRUR) {
        isCheckCZK = checkRUR;
    }

    public boolean isCheckPLN() {
        return isCheckPLN;
    }

    public void setCheckPLN(boolean checkPLN) {
        isCheckPLN = checkPLN;
    }

    public boolean isCheckGBP() {
        return isCheckGBP;
    }

    public void setCheckGBP(boolean checkGBP) {
        isCheckGBP = checkGBP;
    }

    public boolean isCheckMonoBank() {
        return isCheckMonoBank;
    }

    public void setCheckMonoBank(boolean checkMonoBank) {
        isCheckMonoBank = checkMonoBank;
    }

    public boolean isCheckPrivatBank() {
        return isCheckPrivatBank;
    }

    public void setCheckPrivatBank(boolean checkPrivatBank) {
        isCheckPrivatBank = checkPrivatBank;
    }

    public boolean isCheckNBU() {
        return isCheckNBU;
    }

    public void setCheckNBU(boolean checkNBU) {
        isCheckNBU = checkNBU;
    }

    public String getTimeUpdate() {
        return TimeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        TimeUpdate = timeUpdate;
    }

    public boolean isCheckDisableTimeUpdate() {
        return isCheckDisableTimeUpdate;
    }

    public void setCheckDisableTimeUpdate(boolean checkDisableTimeUpdate) {
        isCheckDisableTimeUpdate = checkDisableTimeUpdate;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
