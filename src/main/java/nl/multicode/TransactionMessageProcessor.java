package nl.multicode;

import lombok.RequiredArgsConstructor;
import nl.multicode.model.BalanceMessage;
import nl.multicode.model.CurrencyRateRequestMessage;
import nl.multicode.model.DepositMessage;
import nl.multicode.model.TransactionMessage;
import nl.multicode.model.WithdrawlMessage;
import nl.multicode.repository.WalletRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RequiredArgsConstructor
public class TransactionMessageProcessor {

    private final WalletRepository wallet;

    private static final Logger log = LogManager.getLogger(TransactionMessageProcessor.class);

    public void process(TransactionMessage message) {

        if (message instanceof BalanceMessage balanceMessage) {
            //process balanceMessage
            final var  currency = balanceMessage.getCurrency();
            log.info("wallet balance is {} {}", currency, wallet.getBalance(currency));
        } else if (message instanceof WithdrawlMessage withdrawlMessage) {
            //process withdrawal
            final var currency = withdrawlMessage.getCurrency();
            final var withdrawalAmount = withdrawlMessage.getWithdrawalAmount();
            wallet.withdraw(currency, withdrawalAmount);
            log.info("withdrawing {} {}", withdrawalAmount, currency);
            log.info("wallet balance is {} {}", currency, wallet.getBalance(currency));
        } else if (message instanceof DepositMessage depositMessage) {
            //process withdrawal
            final var currency = depositMessage.getCurrency();
            final var depositAmount = depositMessage.getDepositAmount();
            wallet.deposit(currency, depositAmount);
            log.info("depositing {} {}", depositAmount, currency);
            log.info("wallet balance is {} {}", currency, wallet.getBalance(currency));
        } else if(message instanceof CurrencyRateRequestMessage currencyRateRequestMessage) {
            //process rateRequest
            log.info("Requesting rate for {}",  currencyRateRequestMessage.getCurrency());
        }
    }
}