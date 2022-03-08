package atm.router;

import atm.command.helloworld.HelloWorldModule;
import atm.command.login.LoginCommandModule;
import atm.command.withdraw.AmountsModule;
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
      AmountsModule.class
    })
public interface CommandRouterFactory {
  CommandRouter router();
}
