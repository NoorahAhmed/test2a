package nl.multicode;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.TransactionMessage;
import nl.multicode.model.request.BalanceRequestMessage;
import nl.multicode.model.request.CurrencyRateRequestMessage;
import nl.multicode.model.request.DepositRequestMessage;
import nl.multicode.model.request.WithdrawalRequestMessage;
import nl.multicode.processors.BalanceRequestProcessor;
import nl.multicode.processors.DepositRequestProcessor;
import nl.multicode.processors.RateRequestProcessor;
import nl.multicode.processors.WithdrawalRequestProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RequiredArgsConstructor
public class TransactionMessageProcessingHandler {

    private static final Logger log = LogManager.getLogger(TransactionMessageProcessingHandler.class);
    private final BalanceRequestProcessor balanceRequestProcessor;
    private final DepositRequestProcessor depositRequestProcessor;
    private final WithdrawalRequestProcessor withdrawalRequestProcessor;
    private final RateRequestProcessor rateRequestProcessor;

    public TransactionMessage process(TransactionMessage message) {

        if (message instanceof BalanceRequestMessage balanceRequestMessage) {
            return balanceRequestProcessor.process(balanceRequestMessage);
        } else if (message instanceof WithdrawalRequestMessage withdrawalRequestMessage) {
            return withdrawalRequestProcessor.process(withdrawalRequestMessage);
        } else if (message instanceof DepositRequestMessage depositRequestMessage) {
            return depositRequestProcessor.process(depositRequestMessage);
        } else if (message instanceof CurrencyRateRequestMessage currencyRateRequestMessage) {
            return rateRequestProcessor.process(currencyRateRequestMessage);
        }
        return null;
    }
}