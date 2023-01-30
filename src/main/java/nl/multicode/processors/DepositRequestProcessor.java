package nl.multicode.processors;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.DepositRequest;
import nl.multicode.model.response.BalanceResponse;
import nl.multicode.repository.WalletRepository;

@RequiredArgsConstructor
public class DepositRequestProcessor implements MessageProcessor {

    private final WalletRepository wallet;

    public BalanceResponse process(Object request) {

        final var depositRequest = (DepositRequest) request;
        final var currency = depositRequest.getCurrency();
        final var depositAmount = depositRequest.getAmount();

        wallet.deposit(currency, depositAmount);

        return BalanceResponse.builder()
                .amount(wallet.getBalance(depositRequest.getCurrency()))
                .currency(depositRequest.getCurrency())
                .build();
    }
}
