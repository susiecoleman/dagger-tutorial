package atm.commands.deposit;

import atm.Database;
import atm.commands.Command;
import atm.outputter.Outputter;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

public class DepositCommand implements Command {
  private final Database database;
  private final Outputter outputter;

  @Inject
  DepositCommand(Database database, Outputter outputter) {
    this.database = database;
    this.outputter = outputter;
  }

  @Override
  public Status handleInput(final List<String> input) {
    if (input.size() != 2) {
      return Status.INVALID;
    }
    final var account = database.getAccount(input.get(0));
    account.setBalance(new BigDecimal(input.get(1)));
    outputter.output(account.username() + " now has: " + account.balance());
    return Status.HANDLED;
  }
}
