package com.github.goitproject.bot.button;

import com.github.goitproject.bot.Facade;
import com.github.goitproject.bot.bank.BankResponse;
import com.github.goitproject.bot.button.enum_button.ButtonName;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

import static com.github.goitproject.bot.button.enum_button.ButtonName.*;

public class GetMessageInfo {
    private ArrayList<BankResponse> responses;
    private final Facade facade = new Facade();
    private final String[] precisionArray = {"#0", "#0.0", "#0.00", "#0.000", "#0.0000"};

    public String getMessageInfo(ButtonName bank, Settings settings) {
        String message;
        String precision;
        Optional<BankResponse> bankResponseOptional;
        precision = precisionArray[settings.getPrecision()];

        try {
            responses = facade.getInfo(bank);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (responses == null) {
            return "Помилка запиту " + bank.getName() + ". Спробуйте знову пізніше або оберіть інший банк";
        }

        message = "Курс валют  " + bank.getName() + ":\n";

        if (!settings.isCheckUSD() && !settings.isCheckEUR() && !settings.isCheckCZK()
                && !settings.isCheckPLN() && !settings.isCheckGBP()) {
            settings.setCheckUSD(true);
        }
        if (settings.isCheckUSD()) {
            bankResponseOptional = responses.stream().filter(x -> (x.getCurrency().equals("USD"))).findFirst();
            message += createStringMessage(bankResponseOptional, bank, precision);
        }
        if (settings.isCheckEUR()) {
            bankResponseOptional = responses.stream().filter(x -> (x.getCurrency().equals("EUR"))).findFirst();
            message += createStringMessage(bankResponseOptional, bank, precision);
        }
        if (settings.isCheckCZK()) {
            bankResponseOptional = responses.stream().filter(x -> (x.getCurrency().equals("CZK"))).findFirst();
            message += createStringMessage(bankResponseOptional, bank, precision);
        }
        if (settings.isCheckPLN()) {
            bankResponseOptional = responses.stream().filter(x -> (x.getCurrency().equals("PLN") | x.getCurrency().equals("PLZ"))).findFirst();
            message += createStringMessage(bankResponseOptional, bank, precision);
        }
        if (settings.isCheckGBP()) {
            bankResponseOptional = responses.stream().filter(x -> (x.getCurrency().equals("GBP"))).findFirst();
            message += createStringMessage(bankResponseOptional, bank, precision);
        }
        return message;
    }

    private String createStringMessage(Optional<BankResponse> bankResponse, ButtonName bank, String precision) {
        String priceBuy;
        String priceSale;
        String priceCross;
        String priceRate;
        DecimalFormat format = new DecimalFormat(precision);
        priceBuy = bankResponse.map(BankResponse::getBuy).map(format::format).orElse(null);
        priceSale = bankResponse.map(BankResponse::getSale).map(format::format).orElse(null);
        priceCross = bankResponse.map(BankResponse::getCross).map(format::format).orElse(null);
        priceRate = bankResponse.map(BankResponse::getRate).map(format::format).orElse(null);
        String currency = bankResponse.map(BankResponse::getCurrency).orElse(null);
        if (bank == MONOBANK) {
            if (USD.getName().equals(currency)
                    || EUR.getName().equals(currency)) {
                return currency + "/UAH" + "\n" +
                        "Курс закупки: " + priceBuy + "\n" + "Курс продажу: " + priceSale + "\n\n";
            } else {
                return currency + "/UAH" + "\n" +
                        "Курс: " + priceCross + "\n\n";
            }
        }
        if (bank == NBU) {
            return currency + "/UAH" + "\n" +
                    "Курс: " + priceRate + "\n\n";
        }
        if (bank == PRIVATBANK) {
            return currency + "/UAH" + "\n" +
                    "Курс закупки: " + priceBuy + "\n" + "Курс продажу: " + priceSale + "\n\n";
        }
        return null;
    }
}
