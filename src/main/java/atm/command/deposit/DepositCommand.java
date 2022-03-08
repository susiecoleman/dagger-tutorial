package atm.command.deposit;

import atm.command.Command;
import atm.model.Database;
import atm.model.Result;
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
  public Result handleInput(final List<String> input) {
    if (input.size() != 2) {
      return Result.invalid();
    }
    final var account = database.getAccount(input.get(0));
    account.setBalance(new BigDecimal(input.get(1)));
    outputter.output(account.username() + " now has: " + account.balance());
    return Result.handled();
  }
}
