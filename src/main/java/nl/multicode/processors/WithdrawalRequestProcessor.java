package nl.multicode.processors;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.WithdrawalRequest;
import nl.multicode.model.response.BalanceResponse;
import nl.multicode.repository.WalletRepository;

@RequiredArgsConstructor
public class WithdrawalRequestProcessor implements MessageProcessor {

    private final WalletRepository wallet;

    @Override
    public BalanceResponse process(Object request) {

        final var withdrawalRequest = (WithdrawalRequest) request;
        final var currency = withdrawalRequest.getCurrency();
        final var withdrawalAmount = withdrawalRequest.getAmount();

        wallet.withdraw(currency, withdrawalAmount);

        return BalanceResponse.builder()
                .amount(wallet.getBalance(withdrawalRequest.getCurrency()))
                .currency(withdrawalRequest.getCurrency())
                .build();
    }
}
