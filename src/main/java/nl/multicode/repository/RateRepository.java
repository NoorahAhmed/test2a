package nl.multicode.repository;

import nl.multicode.model.Currency;

import java.util.HashMap;
import java.util.Map;

public class RateRepository {


    private static final Map<Currency, Double> exchangeRates = new HashMap<>();


    public Double getRate(Currency currency) {

        return exchangeRates.get(currency);
    }
}
