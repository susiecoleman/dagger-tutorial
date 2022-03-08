package atm.model;

import atm.command.Command;
import atm.router.CommandRouter;
import java.util.Optional;

public class Result {
  private final Command.Status status;
  private final Optional<CommandRouter> nestedCommandRouter;

  public Result(Command.Status status, Optional<CommandRouter> nestedCommandRouter) {
    this.status = status;
    this.nestedCommandRouter = nestedCommandRouter;
  }

  public static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
    return new Result(Command.Status.HANDLED, Optional.of(nestedCommandRouter));
  }

  public Command.Status status() {
    return status;
  }

  public Optional<CommandRouter> nestedCommandRouter() {
    return nestedCommandRouter;
  }

  public static Result invalid() {
    return new Result(Command.Status.INVALID, Optional.empty());
  }

  public static Result handled() {
    return new Result(Command.Status.HANDLED, Optional.empty());
  }
}
