package com.github.goitproject.bot.bank.mono;

import com.github.goitproject.bot.bank.BankResponse;
import com.github.goitproject.bot.service.ClientService;
import java.util.ArrayList;
import static com.github.goitproject.bot.bank.enum_bank.BankCode.*;
import static com.github.goitproject.bot.bank.enum_bank.BankPath.MONO_PATH;

public class MonoAPI {
    ClientService client = new ClientService();
    ArrayList<BankResponse> responses = new ArrayList<>();

    public ArrayList<BankResponse> getInfoFromMonoBank() throws Exception {
        ArrayList<MonoBank> allCurrency = client.getCurrencyFromBank(MONO_PATH.getBankPath(), CurrencyMonoList.class);
        if (allCurrency == null) {
            return null;
        }
        for (MonoBank mb : allCurrency) {
            if (mb.getCurrencyCodeA().equals(USD_CODE.getCode()) || mb.getCurrencyCodeA()
                    .equals(EUR_CODE.getCode()) || mb.getCurrencyCodeA()
                    .equals(CZK_CODE.getCode()) || mb.getCurrencyCodeA()
                    .equals(PLN_CODE.getCode()) || mb.getCurrencyCodeA().equals(GBR_CODE.getCode())) {
                BankResponse bankResponse = new BankResponse();
                bankResponse.setBank("Монобанк");
                bankResponse.setBuy(mb.getRateBuy());
                bankResponse.setSale(mb.getRateSell());
                bankResponse.setCross(mb.getRateCross());
                bankResponse.setCurrency(getCurrencyNameByCode(mb.getCurrencyCodeA()));
                responses.add(bankResponse);
            }
        }
        return responses;
    }

    private String getCurrencyNameByCode(int code) {
        if (code == 840) {
            return "USD";
        }
        if (code == 978) {
            return "EUR";
        }
        if (code == 203) {
            return "CZK";
        }
        if (code == 985) {
            return "PLN";
        }
        if (code == 826) {
            return "GBP";
        }
        return null;
    }

}
