package atm.commands.login;

import atm.commands.Command;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginCommandModule {
  @Binds
  abstract Command loginCommand(LoginCommand command);
}
