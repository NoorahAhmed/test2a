package nl.multicode;

import nl.multicode.model.TransactionMessage;
import nl.multicode.model.request.BalanceRequestMessage;
import nl.multicode.model.request.CurrencyRateRequestMessage;
import nl.multicode.model.request.DepositRequestMessage;
import nl.multicode.model.request.WithdrawalRequestMessage;
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
        handler.process(withdrawalRequestMessage);
        verify(withdrawalRequestProcessor).process(withdrawalRequestMessage);
    }

    @Test
    void process_deposit() {

        final var depositRequestMessage = mock(DepositRequestMessage.class);
        handler.process(depositRequestMessage);
        verify(depositRequestProcessor).process(depositRequestMessage);
    }

    @Test
    void process_balance() {

        final var balanceRequestMessage = mock(BalanceRequestMessage.class);
        handler.process(balanceRequestMessage);
        verify(balanceRequestProcessor).process(balanceRequestMessage);
    }

    @Test
    void process_rate() {

        final var rateRequestMessage = mock(CurrencyRateRequestMessage.class);
        handler.process(rateRequestMessage);
        verify(rateRequestProcessor).process(rateRequestMessage);
    }

    @Test
    void process_unknown() {

        final var rateRequestMessage = mock(TransactionMessage.class);
        assertThat(handler.process(rateRequestMessage)).isNull();
    }
}