package com.github.goitproject.bot;

import com.github.goitproject.bot.bank.BankResponse;
import com.github.goitproject.bot.bank.mono.MonoAPI;
import com.github.goitproject.bot.bank.nbu.NbuAPI;
import com.github.goitproject.bot.bank.privat.PrivatAPI;
import com.github.goitproject.bot.button.enum_button.ButtonName;

import java.util.ArrayList;

public class Facade {
    private final MonoAPI monoAPI = new MonoAPI();
    private final NbuAPI nbuAPI = new NbuAPI();
    private final PrivatAPI privatAPI = new PrivatAPI();

    public ArrayList<BankResponse> getInfo(ButtonName bank) throws Exception {
        switch (bank) {
            case MONOBANK:
                return monoAPI.getInfoFromMonoBank();
            case NBU:
                return nbuAPI.getInfoFromNbuBank();
            case PRIVATBANK:
                return privatAPI.getInfoFromPrivatBank();
        }
        return null;
    }
}
