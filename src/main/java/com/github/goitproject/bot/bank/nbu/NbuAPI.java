package com.github.goitproject.bot.bank.nbu;

import com.github.goitproject.bot.bank.BankResponse;
import com.github.goitproject.bot.service.ClientService;
import java.util.ArrayList;
import static com.github.goitproject.bot.bank.enum_bank.BankPath.NBU_PATH;
import static com.github.goitproject.bot.button.enum_button.ButtonName.*;

public class NbuAPI {
    ClientService client = new ClientService();
    ArrayList<BankResponse> responses = new ArrayList<>();

    public ArrayList<BankResponse> getInfoFromNbuBank() throws Exception {
        ArrayList<NbuBank> allCurrency = client.getCurrencyFromBank(NBU_PATH.getBankPath(), CurrencyNbuList.class);
        if(allCurrency == null) {
            return null;
        }
            for (NbuBank nb : allCurrency) {
                if (nb.getCc().equals(USD.getName()) || nb.getCc().equals(EUR.getName())  || nb.getCc().equals(CZK.getName()) || nb.getCc().equals(PLN.getName()) || nb.getCc().equals(GBP.getName())) {
                    BankResponse bankResponse = new BankResponse();
                    bankResponse.setBank(NBU.getName());
                    bankResponse.setRate(nb.getRate());
                    bankResponse.setCurrency(nb.getCc());
                    responses.add(bankResponse);
                }
            }
        return responses;
    }
}
