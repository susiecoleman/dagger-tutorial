package atm.commands;

import java.util.List;

public abstract class SingleArgCommand implements Command {
  @Override
  public final Status handleInput(List<String> input) {
    return input.size() == 1 ? handleArg(input.get(0)) : Status.INVALID;
  }

  protected abstract Status handleArg(String arg);
}
