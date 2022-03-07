package atm;

import atm.commands.CommandRouter;
import atm.commands.CommandRouterFactory;
import atm.commands.DaggerCommandRouterFactory;
import java.util.Scanner;

public class CommandLineAtm {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CommandRouterFactory commandRouterFactory = DaggerCommandRouterFactory.create();
    CommandRouter commandRouter = commandRouterFactory.router();

    while (scanner.hasNextLine()) {
      commandRouter.route(scanner.nextLine());
    }
  }
}
