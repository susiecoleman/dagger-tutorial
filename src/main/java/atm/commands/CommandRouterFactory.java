package atm.commands;

import atm.commands.helloworld.HelloWorldModule;
import atm.outputter.SystemOutModule;
import dagger.Component;

@Component(modules = {HelloWorldModule.class, SystemOutModule.class})
public interface CommandRouterFactory {
  CommandRouter router();
}
