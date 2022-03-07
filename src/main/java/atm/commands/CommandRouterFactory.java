package atm.commands;

import atm.commands.login.LoginCommandModule;
import atm.outputter.SystemOutModule;
import dagger.Component;

@Component(modules = {LoginCommandModule.class, SystemOutModule.class})
public interface CommandRouterFactory {
  CommandRouter router();
}
