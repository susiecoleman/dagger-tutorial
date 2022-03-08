package atm.command.withdraw;

import atm.command.helpers.BigDecimalCommand;
import atm.model.Database;
import atm.outputter.Outputter;
import java.math.BigDecimal;
import javax.inject.Inject;

public final class WithdrawCommand extends BigDecimalCommand {
  private final Outputter outputter;
  private final Database.Account account;
  private final BigDecimal minimumBalance;
  private final BigDecimal maximumWithdrawal;

  @Inject
  public WithdrawCommand(
      Outputter outputter,
      Database.Account account,
      @MinimumBalance BigDecimal minimumBalance,
      @MaximumWithdrawal BigDecimal maximumWithdrawal) {
    super(outputter);
    this.outputter = outputter;
    this.account = account;
    this.minimumBalance = minimumBalance;
    this.maximumWithdrawal = maximumWithdrawal;
  }

  @Override
  protected void handleAmount(final BigDecimal amount) {
    if (amount.compareTo(maximumWithdrawal) > 0) {
      outputter.output("You cannot withdraw that much. Over the max limit");
      return;
    }
    BigDecimal newBalance = account.balance().subtract(amount);
    if (newBalance.compareTo(minimumBalance) < 0) {
      outputter.output("You don't have enough money");
    } else {
      account.withdraw(amount);
      outputter.output("Your new balance is: " + account.balance());
    }
  }
}
