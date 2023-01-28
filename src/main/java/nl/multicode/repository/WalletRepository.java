package nl.multicode.repository;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.Currency;

import java.util.Map;

@RequiredArgsConstructor
public class WalletRepository {

    private final Map<Currency, Double> wallet;

    public Double getBalance(final Currency currency) {

        return wallet.get(currency);
    }

    public void withdraw(Currency currency, double amount) {

        wallet.put(currency, wallet.get(currency) - amount);

    }

    public void deposit(Currency currency, double amount) {

        wallet.put(currency, wallet.get(currency) + amount);
    }

}
