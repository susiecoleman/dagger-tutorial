package atm.router;

import atm.command.UserCommandsModule;
import atm.command.helloworld.HelloWorldModule;
import atm.command.login.LoginCommandModule;
import atm.outputter.SystemOutModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(
    modules = {
      LoginCommandModule.class,
      HelloWorldModule.class,
      UserCommandsModule.class,
      SystemOutModule.class
    })
public interface CommandRouterFactory {
  CommandRouter router();
}
