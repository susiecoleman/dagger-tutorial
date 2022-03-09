package atm.command.usercommands.logout;

import atm.command.Command;
import atm.model.Result;
import java.util.List;
import javax.inject.Inject;

public class LogoutCommand implements Command {

  @Inject
  public LogoutCommand() {}

  @Override
  public Result handleInput(final List<String> input) {
    return input.isEmpty() ? Result.inputCompleted() : Result.invalid();
  }
}
