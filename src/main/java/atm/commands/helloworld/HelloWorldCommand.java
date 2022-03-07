package atm.commands.helloworld;

import atm.commands.Command;
import atm.outputter.Outputter;
import java.util.List;
import javax.inject.Inject;

final class HelloWorldCommand implements Command {
  private final Outputter outputter;

  @Inject
  HelloWorldCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override
  public String key() {
    return "hello";
  }

  @Override
  public Status handleInput(final List<String> input) {
    if (!input.isEmpty()) {
      return Status.INVALID;
    }
    outputter.output("world!");
    return Status.HANDLED;
  }
}
