package nl.multicode.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WithdrawlMessage implements TransactionMessage {

    private final int withdrawalAmount;
    private final Currency currency;
}
