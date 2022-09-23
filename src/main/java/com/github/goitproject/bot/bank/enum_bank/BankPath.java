package com.github.goitproject.bot.bank.enum_bank;

public enum BankPath {
    MONO_PATH("https://api.monobank.ua/bank/currency"),
    PRIVAT_PATH_USD_EUR("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5"),
    PRIVAT_PATH_CZK_PLN_GBP("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=4"),
    NBU_PATH("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
    private final String bankPath;

    BankPath(String bankName) {
        this.bankPath = bankName;
    }

    public String getBankPath() {
        return bankPath;
    }
}
