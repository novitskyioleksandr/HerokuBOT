package com.github.goitproject.bot.bank.mono;

public class MonoBank {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private  Long date;
    private Float rateSell;
    private Float rateBuy;
    private Float rateCross;

    public MonoBank(Integer currencyCodeA, Integer currencyCodeB, Long date, Float rateSell, Float rateBuy, Float rateCross) {
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.date = date;
        this.rateSell = rateSell;
        this.rateBuy = rateBuy;
        this.rateCross = rateCross;
    }

    public Integer getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(Integer currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public Integer getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(Integer currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Float getRateSell() {
        return rateSell;
    }

    public void setRateSell(Float rateSell) {
        this.rateSell = rateSell;
    }

    public Float getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(Float rateBuy) {
        this.rateBuy = rateBuy;
    }

    public Float getRateCross() {
        return rateCross;
    }

    public void setRateCross(Float rateCross) {
        this.rateCross = rateCross;
    }
}
