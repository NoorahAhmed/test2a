package nl.multicode.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepositMessage implements TransactionMessage {

    private final int depositAmount;
    private final Currency currency;
}
