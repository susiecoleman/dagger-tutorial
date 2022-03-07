package atm.commands;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public final class CommandRouter {
  private final Map<String, Command> commands;

  @Inject
  CommandRouter(Map<String, Command> commands) {
    this.commands = commands;
  }

  public Command.Status route(String input) {
    final var splitInput = split(input);
    if (splitInput.isEmpty()) {
      return invalidCommand(input);
    }

    final var commandKey = splitInput.get(0);
    final var command = commands.get(commandKey);
    if (command == null) {
      return invalidCommand(input);
    }

    final var status = command.handleInput(splitInput.subList(1, splitInput.size()));
    if (status == Command.Status.INVALID) {
      System.out.println(commandKey + ": invalid arguments");
    }
    return status;
  }

  private Command.Status invalidCommand(String input) {
    System.out.printf("couldn't understand \"%s\". please try again%n", input);
    return Command.Status.INVALID;
  }

  private static List<String> split(String string) {
    return List.of(string.split("\\s+"));
  }
}
