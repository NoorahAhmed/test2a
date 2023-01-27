package nl.multicode.processors;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.BalanceRequestMessage;
import nl.multicode.model.response.BalanceResponseMessage;
import nl.multicode.repository.MessageProcessor;
import nl.multicode.repository.WalletRepository;

@RequiredArgsConstructor
public class BalanceRequestProcessor implements MessageProcessor<BalanceRequestMessage, BalanceResponseMessage> {

    private final WalletRepository wallet;

    @Override
    public BalanceResponseMessage process(BalanceRequestMessage balanceRequestMessage) {

        final var currency = balanceRequestMessage.getCurrency();

        return BalanceResponseMessage.builder()
                .amount(wallet.getBalance(currency))
                .currency(currency)
                .build();
    }
}
