package com.github.goitproject.bot.bank;

public class BankResponse {
    private String currency;
    private Float buy;
    private Float sale;
    private Float cross;
    private Float rate;
    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getBuy() {
        return buy;
    }

    public void setBuy(Float buy) {
        this.buy = buy;
    }

    public Float getSale() {
        return sale;
    }

    public void setSale(Float sale) {
        this.sale = sale;
    }

    public Float getCross() {
        return cross;
    }

    public void setCross(Float cross) {
        this.cross = cross;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
