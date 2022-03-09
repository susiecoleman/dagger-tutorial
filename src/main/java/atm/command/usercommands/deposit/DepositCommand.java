package atm.command.usercommands.deposit;

import atm.command.helpers.BigDecimalCommand;
import atm.command.helpers.WithdrawalLimiter;
import atm.database.account.Account;
import atm.outputter.Outputter;
import java.math.BigDecimal;
import javax.inject.Inject;

public class DepositCommand extends BigDecimalCommand {
  private final Account account;
  private final Outputter outputter;
  private final WithdrawalLimiter withdrawalLimiter;

  @Inject
  DepositCommand(Outputter outputter, Account account, WithdrawalLimiter withdrawalLimiter) {
    super(outputter);
    this.account = account;
    this.outputter = outputter;
    this.withdrawalLimiter = withdrawalLimiter;
  }

  @Override
  public void handleAmount(BigDecimal amount) {
    account.deposit(amount);
    withdrawalLimiter.recordDeposit(amount);
    outputter.output(account.username() + " now has: " + account.balance());
  }
}
