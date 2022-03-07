package atm.commands.login;

import atm.Database;
import atm.commands.SingleArgCommand;
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
  protected Status handleArg(final String username) {
    final var account = database.getAccount(username);
    outputter.output(username + " is logged in with balance: " + account.balance());
    return Status.HANDLED;
  }
}
