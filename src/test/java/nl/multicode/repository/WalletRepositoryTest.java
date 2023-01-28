package nl.multicode.repository;

import nl.multicode.model.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class WalletRepositoryTest {


    @Mock
    Map<Currency, Double> currencyDoubleMap;
    @InjectMocks
    private WalletRepository repository;

    @Test
    void getBalance() {

        final var dollarsBalance = Double.valueOf(10);
        when(currencyDoubleMap.get(Currency.DOLLAR)).thenReturn(dollarsBalance);
        assertThat(repository.getBalance(Currency.DOLLAR)).isEqualTo(dollarsBalance);
        verify(currencyDoubleMap).get(Currency.DOLLAR);
    }

    @Test
    void withdraw() {
        final var dollarsBalance = Double.valueOf(10);
        when(currencyDoubleMap.get(Currency.KRONA)).thenReturn(dollarsBalance);
        repository.withdraw(Currency.KRONA, 1d);
        verify(currencyDoubleMap).get(Currency.KRONA);
        verify(currencyDoubleMap).put(eq(Currency.KRONA),eq(9d));
    }

    @Test
    void deposit() {
        final var dollarsBalance = Double.valueOf(9d);
        when(currencyDoubleMap.get(Currency.DINAR)).thenReturn(dollarsBalance);
        repository.deposit(Currency.DINAR, 1d);
        verify(currencyDoubleMap).get(Currency.DINAR);
        verify(currencyDoubleMap).put(eq(Currency.DINAR),eq(10d));
    }
}