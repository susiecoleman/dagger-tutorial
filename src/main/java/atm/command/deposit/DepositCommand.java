package atm.command.deposit;

import atm.command.helpers.BigDecimalCommand;
import atm.command.helpers.WithdrawalLimiter;
import atm.model.Database;
import atm.outputter.Outputter;
import java.math.BigDecimal;
import javax.inject.Inject;

public class DepositCommand extends BigDecimalCommand {
  private final Database.Account account;
  private final Outputter outputter;
  private final WithdrawalLimiter withdrawalLimiter;

  @Inject
  DepositCommand(
      Outputter outputter, Database.Account account, WithdrawalLimiter withdrawalLimiter) {
    super(outputter);
    this.account = account;
    this.outputter = outputter;
    this.withdrawalLimiter = withdrawalLimiter;
  }

  @Override
  public void handleAmount(BigDecimal amount) {
    account.setBalance(amount);
    withdrawalLimiter.recordDeposit(amount);
    outputter.output(account.username() + " now has: " + account.balance());
  }
}
