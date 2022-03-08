package atm.command.login;

import atm.command.SingleArgCommand;
import atm.model.Database;
import atm.model.Result;
import atm.outputter.Outputter;
import javax.inject.Inject;

public final class LoginCommand extends SingleArgCommand {
  private final Outputter outputter;
  private final Database database;

  @Inject
  public LoginCommand(Database database, Outputter outputter) {
    this.outputter = outputter;
    this.database = database;
  }

  @Override
  protected Result handleArg(final String username) {
    final var account = database.getAccount(username);
    outputter.output(username + " is logged in with balance: " + account.balance());
    return Result.handled();
  }
}
