package nl.multicode;

import nl.multicode.model.Currency;
import nl.multicode.repository.RateRepository;
import nl.multicode.repository.WalletRepository;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TransactionMessageProcessorTest {

    private Map<Currency,Integer> wallet;
    private WalletRepository repository;
    private RateRepository rateRepository;

    public void setup(){

    }

    @Test
    void process() {

    }
}