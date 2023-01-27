package nl.multicode.processors;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.request.WithdrawalRequestMessage;
import nl.multicode.model.response.BalanceResponseMessage;
import nl.multicode.repository.MessageProcessor;
import nl.multicode.repository.WalletRepository;

@RequiredArgsConstructor
public class WithdrawalRequestProcessor implements MessageProcessor<WithdrawalRequestMessage, BalanceResponseMessage> {

    private final WalletRepository wallet;

    @Override
    public BalanceResponseMessage process(WithdrawalRequestMessage withdrawalRequest) {

        final var currency = withdrawalRequest.getCurrency();
        final var withdrawalAmount = withdrawalRequest.getWithdrawalAmount();

        wallet.withdraw(currency, withdrawalAmount);

        return BalanceResponseMessage.builder()
                .amount(wallet.getBalance(withdrawalRequest.getCurrency()))
                .currency(withdrawalRequest.getCurrency())
                .build();
    }
}
