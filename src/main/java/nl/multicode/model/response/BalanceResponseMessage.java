package nl.multicode.model.response;

import lombok.Builder;
import lombok.Getter;
import nl.multicode.model.Currency;
import nl.multicode.model.TransactionMessage;

@Getter
@Builder
public class BalanceResponseMessage implements TransactionMessage {

    private final Double amount;
    private final Currency currency;
}
