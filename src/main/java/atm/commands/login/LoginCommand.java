package atm.commands.login;

import atm.commands.SingleArgCommand;
import atm.outputter.Outputter;
import javax.inject.Inject;

public final class LoginCommand extends SingleArgCommand {
  private final Outputter outputter;

  @Inject
  public LoginCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override
  public String key() {
    return "login";
  }

  @Override
  protected Status handleArg(final String username) {
    outputter.output(username + " is logged in.");
    return Status.HANDLED;
  }
}
