package atm.command;

import atm.model.Result;
import java.util.List;

public interface Command {

  Result handleInput(List<String> input);

  enum Status {
    INVALID,
    HANDLED,
    INPUT_COMPLETED
  }
}
