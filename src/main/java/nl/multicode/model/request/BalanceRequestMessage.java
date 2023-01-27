package nl.multicode.model.request;

import lombok.Builder;
import lombok.Getter;
import nl.multicode.model.Currency;
import nl.multicode.model.TransactionMessage;


@Getter
@Builder
public class BalanceRequestMessage implements TransactionMessage {

    private final Currency currency;
}
