package nl.multicode;

import nl.multicode.model.TransactionMessage;
import nl.multicode.model.request.BalanceRequestMessage;
import nl.multicode.model.request.CurrencyRateRequestMessage;
import nl.multicode.model.request.DepositRequestMessage;
import nl.multicode.model.request.WithdrawalRequestMessage;
import nl.multicode.model.response.BalanceResponseMessage;
import nl.multicode.model.response.CurrencyRateResponseMessage;
import nl.multicode.processors.BalanceRequestProcessor;
import nl.multicode.processors.DepositRequestProcessor;
import nl.multicode.processors.RateRequestProcessor;
import nl.multicode.processors.WithdrawalRequestProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TransactionMessageProcessingHandlerTest {

    @Mock
    private BalanceRequestProcessor balanceRequestProcessor;
    @Mock
    private DepositRequestProcessor depositRequestProcessor;
    @Mock
    private WithdrawalRequestProcessor withdrawalRequestProcessor;
    @Mock
    private RateRequestProcessor rateRequestProcessor;

    @InjectMocks
    private TransactionMessageProcessingHandler handler;


    @Test
    void process_withdrawal() {

        final var withdrawalRequestMessage = mock(WithdrawalRequestMessage.class);
        final var responseMessage = mock(BalanceResponseMessage.class);
        when(withdrawalRequestProcessor.process(withdrawalRequestMessage)).thenReturn(responseMessage);

        final var response = handler.process(withdrawalRequestMessage);

        verify(withdrawalRequestProcessor).process(withdrawalRequestMessage);
        assertThat(response).isEqualTo(responseMessage);
    }

    @Test
    void process_deposit() {

        final var depositRequestMessage = mock(DepositRequestMessage.class);
        final var responseMessage = mock(BalanceResponseMessage.class);
        when(depositRequestProcessor.process(depositRequestMessage)).thenReturn(responseMessage);

        final var response = handler.process(depositRequestMessage);

        verify(depositRequestProcessor).process(depositRequestMessage);
        assertThat(response).isEqualTo(responseMessage);
    }

    @Test
    void process_balance() {

        final var balanceRequestMessage = mock(BalanceRequestMessage.class);
        final var responseMessage = mock(BalanceResponseMessage.class);
        when(balanceRequestProcessor.process(balanceRequestMessage)).thenReturn(responseMessage);

        final var response = handler.process(balanceRequestMessage);

        verify(balanceRequestProcessor).process(balanceRequestMessage);
        assertThat(response).isEqualTo(responseMessage);
    }

    @Test
    void process_rate() {

        final var rateRequestMessage = mock(CurrencyRateRequestMessage.class);
        final var responseMessage = mock(CurrencyRateResponseMessage.class);
        when(rateRequestProcessor.process(rateRequestMessage)).thenReturn(responseMessage);
        final var response = handler.process(rateRequestMessage);
        verify(rateRequestProcessor).process(rateRequestMessage);
        assertThat(response).isEqualTo(responseMessage);
    }

    @Test
    void process_unknown() {

        final var rateRequestMessage = mock(TransactionMessage.class);
        assertThat(handler.process(rateRequestMessage)).isNull();
    }
}