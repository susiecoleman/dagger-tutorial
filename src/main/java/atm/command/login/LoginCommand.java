package atm.command.login;

import atm.command.helpers.SingleArgCommand;
import atm.database.account.Account;
import atm.model.Result;
import atm.outputter.Outputter;
import atm.router.UserCommandsRouter;
import java.util.Optional;
import javax.inject.Inject;

public final class LoginCommand extends SingleArgCommand {
  private final Outputter outputter;
  private final UserCommandsRouter.Factory userCommandsRouterFactory;
  private final Optional<Account> account;

  @Inject
  public LoginCommand(
      Outputter outputter,
      UserCommandsRouter.Factory userCommandsRouterFactory,
      Optional<Account> account) {
    this.outputter = outputter;
    this.userCommandsRouterFactory = userCommandsRouterFactory;
    this.account = account;
  }

  @Override
  protected Result handleArg(final String username) {
    if (account.isPresent()) {
      String loggedInUser = account.get().username();
      outputter.output(loggedInUser + " is already logged in");
      if (!loggedInUser.equals(username)) {
        outputter.output("run `logout` first before trying to log in another user");
      }
      return Result.handled();
    } else {
      UserCommandsRouter userCommands = userCommandsRouterFactory.create(username);
      return Result.enterNestedCommandSet(userCommands.router());
    }
  }
}
