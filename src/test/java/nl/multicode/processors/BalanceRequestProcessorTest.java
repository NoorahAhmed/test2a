package nl.multicode.processors;

import nl.multicode.model.Currency;
import nl.multicode.model.request.BalanceRequestMessage;
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
class BalanceRequestProcessorTest {

    @Mock
    private WalletRepository wallet;

    @InjectMocks
    private BalanceRequestProcessor processor;

    @Test
    void process() {

        when(wallet.getBalance(DOLLAR)).thenReturn(10d);
        final var response = processor.process(BalanceRequestMessage.builder()
                .currency(DOLLAR)
                .build());
        assertThat(response.getAmount()).isEqualTo(10d);
        assertThat(response.getCurrency()).isEqualTo(DOLLAR);
        verify(wallet).getBalance(DOLLAR);
    }
}