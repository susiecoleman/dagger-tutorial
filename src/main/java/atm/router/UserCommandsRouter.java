package atm.router;

import atm.PerSession;
import atm.command.UserCommandsModule;
import atm.model.Database;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@PerSession
@Subcomponent(modules = UserCommandsModule.class)
public interface UserCommandsRouter {
  CommandRouter router();

  @Subcomponent.Factory
  interface Factory {
    UserCommandsRouter create(@BindsInstance Database.Account account);
  }

  @Module(subcomponents = UserCommandsRouter.class)
  interface InstallationModule {}
}
