package com.github.goitproject.bot.button.enum_button;

public enum ButtonName {
    START("/start"),
    INFO("\u2709\uFE0F  Інформація"),
    SETTINGS("\u2699\uFE0F Налаштування"),
    BACK("Повернутись"),

    BANK("\uD83C\uDFE6 Банк"),
    MONOBANK("Монобанк"),
    PRIVATBANK("Приватбанк"),
    NBU("НБУ"),

    CURRENCY("\uD83D\uDCB0 Валюта"),
    USD("USD"),
    EUR("EUR"),
    CZK("CZK"),
    PLN("PLN"),
    PLZ("PLZ"),
    GBP("GBP"),

    PRECISION("\uD83C\uDFAF Кіл-сть знаків після коми"),
    PRECISION_TWO("2"),
    PRECISION_THREE("3"),
    PRECISION_FOUR("4"),

    TIME_UPDATE("\u23F0  Час сповіщень"),//?

    TIME_UPDATE_NINE("9:00"),
    TIME_UPDATE_THEN("10:00"),
    TIME_UPDATE_ELEVEN("11:00"),
    TIME_UPDATE_TWELVE("12:00"),
    TIME_UPDATE_THIRTEEN("13:00"),
    TIME_UPDATE_FOURTEEN("14:00"),
    TIME_UPDATE_FIFTEEN("15:00"),
    TIME_UPDATE_SIXTEEN("16:00"),
    TIME_UPDATE_SEVENTEEN("17:00"),
    TIME_UPDATE_EIGHTEEN("18:00"),

    TIME_UPDATE_DISABLE("Вимкнути");
    private String buttonName;

    ButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getName() {
        return buttonName;
    }
}
