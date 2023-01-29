package nl.multicode.processors;

import nl.multicode.model.request.DepositRequestMessage;
import nl.multicode.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static nl.multicode.model.Currency.DOLLAR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepositRequestProcessorTest {

    public static final double AMOUNT = 10d;
    @Mock
    private WalletRepository wallet;

    @InjectMocks
    private DepositRequestProcessor processor;

    @Test
    void process() {

        when(wallet.getBalance(DOLLAR)).thenReturn(AMOUNT);
        final var response = processor.process(DepositRequestMessage.builder()
                .currency(DOLLAR)
                .amount(AMOUNT)
                .build());
        verify(wallet).deposit(DOLLAR, AMOUNT);
        verify(wallet).getBalance(DOLLAR);
        assertThat(response.getAmount()).isEqualTo(AMOUNT);
        assertThat(response.getCurrency()).isEqualTo(DOLLAR);
    }
}