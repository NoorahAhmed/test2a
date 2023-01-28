package nl.multicode.repository;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.Currency;

import java.util.Map;

@RequiredArgsConstructor
public class RateRepository {

    private final Map<Currency, Double> exchangeRates;

    public Double getRate(Currency currency) {

        return exchangeRates.get(currency);
    }

    public void putRate(Currency currency, double rate) {

        exchangeRates.put(currency, rate);
    }
}
