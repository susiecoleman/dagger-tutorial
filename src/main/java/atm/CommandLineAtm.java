package atm;

import atm.commands.DaggerCommandRouterFactory;
import java.util.Scanner;

public class CommandLineAtm {

  public static void main(String[] args) {
    final var scanner = new Scanner(System.in);
    final var commandRouterFactory = DaggerCommandRouterFactory.create();
    final var commandRouter = commandRouterFactory.router();

    while (scanner.hasNextLine()) {
      commandRouter.route(scanner.nextLine());
    }
  }
}
