package atm.router;

import atm.PerSession;
import atm.command.usercommands.UserCommandsModule;
import atm.database.account.AccountModule;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@PerSession
@Subcomponent(modules = {UserCommandsModule.class, AccountModule.class})
public interface UserCommandsRouter {
  CommandRouter router();

  @Subcomponent.Factory
  interface Factory {
    UserCommandsRouter create(@BindsInstance @Username String username);
  }

  @Module(subcomponents = UserCommandsRouter.class)
  interface InstallationModule {}
}
