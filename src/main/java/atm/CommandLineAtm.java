package atm;

import atm.processor.DaggerCommandProcessorFactory;
import java.util.Scanner;

public class CommandLineAtm {

  public static void main(String[] args) {
    final var scanner = new Scanner(System.in);
    final var commandProcessor = DaggerCommandProcessorFactory.create().processor();

    while (scanner.hasNextLine()) {
      commandProcessor.process(scanner.nextLine());
    }
  }
}
