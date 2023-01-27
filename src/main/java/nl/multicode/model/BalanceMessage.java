package nl.multicode.model;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class BalanceMessage implements TransactionMessage {

    private final Currency currency;
}
