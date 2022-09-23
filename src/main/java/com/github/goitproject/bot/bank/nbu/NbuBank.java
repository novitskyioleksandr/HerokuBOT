package com.github.goitproject.bot.bank.nbu;

public class NbuBank {
    private Integer r030;
    private String txt;
    private Float rate;
    private String cc;
    private String exchangedate;

    public NbuBank(Integer r030, String txt, Float rate, String cc, String exchangedate) {
        this.r030 = r030;
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public Integer getR030() {
        return r030;
    }

    public void setR030(Integer r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }
}
