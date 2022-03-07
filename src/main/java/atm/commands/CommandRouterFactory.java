package atm.commands;

import atm.commands.helloworld.HelloWorldModule;
import atm.commands.login.LoginCommandModule;
import atm.outputter.SystemOutModule;
import dagger.Component;

@Component(modules = {LoginCommandModule.class, HelloWorldModule.class, SystemOutModule.class})
public interface CommandRouterFactory {
  CommandRouter router();
}
