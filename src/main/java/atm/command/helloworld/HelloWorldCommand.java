package atm.command.helloworld;

import atm.command.Command;
import atm.model.Result;
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
  public Result handleInput(final List<String> input) {
    if (!input.isEmpty()) {
      return Result.invalid();
    }
    outputter.output("world!");
    return Result.handled();
  }
}
