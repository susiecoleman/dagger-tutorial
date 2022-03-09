package atm.router;

import atm.command.helloworld.HelloWorldModule;
import atm.command.login.LoginCommandModule;
import atm.command.usercommands.withdraw.AmountsModule;
import atm.database.InMemoryDatabaseModule;
import atm.outputter.SystemOutModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(
    modules = {
      LoginCommandModule.class,
      HelloWorldModule.class,
      SystemOutModule.class,
      UserCommandsRouter.InstallationModule.class,
      AmountsModule.class,
      InMemoryDatabaseModule.class
    })
public interface CommandRouterFactory {
  CommandRouter router();
}
