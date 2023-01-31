package nl.multicode;

import nl.multicode.model.request.BalanceRequest;
import nl.multicode.model.request.CurrencyRateRequest;
import nl.multicode.model.request.DepositRequest;
import nl.multicode.model.request.RequestMessage;
import nl.multicode.model.request.WithdrawalRequest;
import nl.multicode.processors.BalanceRequestProcessor;
import nl.multicode.processors.DepositRequestProcessor;
import nl.multicode.processors.MessageProcessor;
import nl.multicode.processors.RateRequestProcessor;
import nl.multicode.processors.WithdrawalRequestProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static java.util.Map.entry;


public class TransactionMessageProcessingHandler {

    private static final Logger log = LogManager.getLogger(TransactionMessageProcessingHandler.class);

    private final Map<String, MessageProcessor> messageProcessors;

    public TransactionMessageProcessingHandler(final BalanceRequestProcessor balanceRequestProcessor,
                                               final DepositRequestProcessor depositRequestProcessor,
                                               final WithdrawalRequestProcessor withdrawalRequestProcessor,
                                               final RateRequestProcessor rateRequestProcessor) {

        this.messageProcessors = Map.ofEntries(
                entry(BalanceRequest.class.getCanonicalName(), balanceRequestProcessor),
                entry(WithdrawalRequest.class.getCanonicalName(), withdrawalRequestProcessor),
                entry(DepositRequest.class.getCanonicalName(), depositRequestProcessor),
                entry(CurrencyRateRequest.class.getCanonicalName(), rateRequestProcessor));
    }


    public Object process(RequestMessage message) {

        log.info("Processing requested for message {}", message);
        return getMessageProcessor(message) != null ? getMessageProcessor(message).process(message) : null;
    }

    private MessageProcessor getMessageProcessor(RequestMessage message) {

        return message != null ? this.messageProcessors.get(message.getClass().getCanonicalName()) : null;
    }
}