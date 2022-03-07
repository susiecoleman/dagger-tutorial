package atm.commands;

import atm.commands.helloworld.HelloWorldModule;
import atm.commands.login.LoginCommandModule;
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
