package nl.multicode.model.request;

import lombok.Builder;
import lombok.Data;
import nl.multicode.model.Currency;
import nl.multicode.model.TransactionMessage;

@Data
@Builder
public class WithdrawalRequestMessage implements TransactionMessage {

    private final int withdrawalAmount;
    private final Currency currency;
}
