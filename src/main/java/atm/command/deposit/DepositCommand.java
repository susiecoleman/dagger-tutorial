package atm.command.deposit;

import atm.command.helpers.BigDecimalCommand;
import atm.model.Database;
import atm.outputter.Outputter;
import java.math.BigDecimal;
import javax.inject.Inject;

public class DepositCommand extends BigDecimalCommand {
  private final Database.Account account;
  private final Outputter outputter;

  @Inject
  DepositCommand(Outputter outputter, Database.Account account) {
    super(outputter);
    this.account = account;
    this.outputter = outputter;
  }

  @Override
  public void handleAmount(BigDecimal amount) {
    account.setBalance(amount);
    outputter.output(account.username() + " now has: " + account.balance());
  }
}
