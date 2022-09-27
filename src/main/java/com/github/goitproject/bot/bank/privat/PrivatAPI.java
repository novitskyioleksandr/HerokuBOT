package com.github.goitproject.bot.bank.privat;

import com.github.goitproject.bot.bank.BankResponse;
import com.github.goitproject.bot.service.ClientService;
import java.util.ArrayList;
import static com.github.goitproject.bot.bank.enum_bank.BankPath.*;
import static com.github.goitproject.bot.button.enum_button.ButtonName.*;

public class PrivatAPI {
    ClientService client = new ClientService();
    ArrayList<BankResponse> responses = new ArrayList<>();

    public ArrayList<BankResponse> getInfoFromPrivatBank() throws Exception {
        ArrayList<PrivatBank> currency_USD_EUR = client.getCurrencyFromBank(PRIVAT_PATH_USD_EUR.getBankPath(), CurrencyPrivatList.class);
        ArrayList<PrivatBank> currency_CZK_PLN_GBP = client.getCurrencyFromBank(PRIVAT_PATH_CZK_PLN_GBP.getBankPath(), CurrencyPrivatList.class);
        if(currency_USD_EUR == null|currency_CZK_PLN_GBP==null) {
            return null;
        }
        for (PrivatBank pb : currency_USD_EUR) {
            if (pb.getCcy().equals(USD.getName()) || pb.getCcy().equals(EUR.getName())) {
                BankResponse bankResponse = new BankResponse();
                bankResponse.setBank("Приватбанк");
                bankResponse.setBuy(pb.getBuy());
                bankResponse.setSale(pb.getSale());
                bankResponse.setCurrency(pb.getCcy());
                responses.add(bankResponse);
            }}
        for (PrivatBank pb : currency_CZK_PLN_GBP) {
            if (pb.getCcy().equals(CZK.getName()) || pb.getCcy().equals(PLZ.getName()) || pb.getCcy().equals(GBP.getName())) {
                BankResponse bankResponse = new BankResponse();
                bankResponse.setBank("Приватбанк");
                bankResponse.setBuy(pb.getBuy());
                bankResponse.setSale(pb.getSale());
                bankResponse.setCurrency(pb.getCcy());
                responses.add(bankResponse);
            }
        }
        return responses;
    }
}
