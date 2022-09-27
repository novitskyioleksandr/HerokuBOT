package com.github.goitproject.bot.button.enum_button;

public enum ButtonCallBack {
    INFO_CALLBACK("/info"),
    SETTINGS_CALLBACK("/settings"),
    MY_SETTINGS_CALLBACK("/my_settings"),
    HELP_CALLBACK("/help"),
    BACK_CALLBACK("/back"),
    BACK_TO_START_CALLBACK("/back_to_start"),

    BANK_CALLBACK("bank"),
    MONOBANK_CALLBACK("mono_bank"),
    PRIVATBANK_CALLBACK("privat_bank"),
    NBU_CALLBACK("nbu_bank"),

    CURRENCY_CALLBACK("currency"),
    USD_CALLBACK("USD_currency"),
    EUR_CALLBACK("EUR_currency"),
    CZK_CALLBACK("CZK_currency"),
    PLN_CALLBACK("PLN_currency"),
    GBP_CALLBACK("GBP_currency"),

    PRECISION_CALLBACK("precision"),
    PRECISION_TWO_CALLBACK("2"),
    PRECISION_THREE_CALLBACK("3"),
    PRECISION_FOUR_CALLBACK("4"),

    TIME_UPDATE_CALLBACK("time_update"),
    TIME_UPDATE_NINE_CALLBACK("9:00"),
    TIME_UPDATE_TEN_CALLBACK("10:00"),
    TIME_UPDATE_ELEVEN_CALLBACK("11:00"),
    TIME_UPDATE_TWELVE_CALLBACK("12:00"),
    TIME_UPDATE_THIRTEEN_CALLBACK("13:00"),
    TIME_UPDATE_FOURTEEN_CALLBACK("14:00"),
    TIME_UPDATE_FIFTEEN_CALLBACK("15:00"),
    TIME_UPDATE_SIXTEEN_CALLBACK("16:00"),
    TIME_UPDATE_SEVENTEEN_CALLBACK("17:00"),
    TIME_UPDATE_EIGHTEEN_CALLBACK("18:00"),

    TIME_UPDATE_DISABLE_CALLBACK("disable_update");
    private final String callback;

    ButtonCallBack(String callback) {
        this.callback = callback;
    }
    public String getCallback(){
        return callback;
    }

}
