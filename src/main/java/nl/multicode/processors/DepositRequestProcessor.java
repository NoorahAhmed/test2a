package nl.multicode.processors;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.DepositRequestMessage;
import nl.multicode.model.response.BalanceResponseMessage;
import nl.multicode.repository.MessageProcessor;
import nl.multicode.repository.WalletRepository;

@RequiredArgsConstructor
public class DepositRequestProcessor implements MessageProcessor<DepositRequestMessage, BalanceResponseMessage> {

    private final WalletRepository wallet;

    @Override
    public BalanceResponseMessage process(DepositRequestMessage depositRequest) {

        final var currency = depositRequest.getCurrency();
        final var depositAmount = depositRequest.getDepositAmount();

        wallet.deposit(currency, depositAmount);

        return BalanceResponseMessage.builder()
                .amount(wallet.getBalance(depositRequest.getCurrency()))
                .currency(depositRequest.getCurrency())
                .build();
    }
}
