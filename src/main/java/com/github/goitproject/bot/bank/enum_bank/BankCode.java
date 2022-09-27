package com.github.goitproject.bot.bank.enum_bank;

public enum BankCode {
    USD_CODE(840),
    EUR_CODE(978),
    CZK_CODE(203),
    PLN_CODE(985),
    GBR_CODE(826);
    private final Integer code;

    BankCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}


