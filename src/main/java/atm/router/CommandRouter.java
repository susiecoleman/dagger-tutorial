package atm.router;

import atm.command.Command;
import atm.model.Result;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.inject.Inject;

public final class CommandRouter {
  private final Map<String, Command> commands;

  @Inject
  CommandRouter(Map<String, Command> commands) {
    this.commands = commands;
  }

  public Result route(String input) {
    final var splitInput = split(input);
    if (splitInput.isEmpty()) {
      return invalidCommand(input);
    }

    final var commandKey = splitInput.get(0);
    final var command = commands.get(commandKey);
    if (command == null) {
      return invalidCommand(input);
    }

    final var result = command.handleInput(splitInput.subList(1, splitInput.size()));
    if (result.status() == Command.Status.INVALID) {
      System.out.println(commandKey + ": invalid arguments");
    }
    return result;
  }

  private Result invalidCommand(String input) {
    System.out.printf("couldn't understand \"%s\". please try again%n", input);
    return new Result(Command.Status.INVALID, Optional.empty());
  }

  private static List<String> split(String string) {
    return List.of(string.split("\\s+"));
  }
}
