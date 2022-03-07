package atm.commands;

import java.util.List;

public interface Command {

  Status handleInput(List<String> input);

  enum Status {
    INVALID,
    HANDLED
  }
}
