package atm.processor;

import atm.command.Command;
import atm.model.Result;
import atm.router.CommandRouter;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class CommandProcessor {
  private final Deque<CommandRouter> commandRouterStack = new ArrayDeque<>();

  @Inject
  CommandProcessor(CommandRouter firstCommandRouter) {
    commandRouterStack.push(firstCommandRouter);
  }

  public Command.Status process(String input) {
    Result result = commandRouterStack.peek().route(input);
    if (result.status().equals(Command.Status.INPUT_COMPLETED)) {
      commandRouterStack.pop();
      return commandRouterStack.isEmpty() ? Command.Status.INPUT_COMPLETED : Command.Status.HANDLED;
    }
    result.nestedCommandRouter().ifPresent(commandRouterStack::push);
    return result.status();
  }
}
