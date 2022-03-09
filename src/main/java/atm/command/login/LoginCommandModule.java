package atm.command.login;

import atm.command.Command;
import atm.database.account.Account;
import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class LoginCommandModule {
  @Binds
  @IntoMap
  @StringKey("login")
  abstract Command loginCommand(LoginCommand command);

  @BindsOptionalOf
  abstract Account optionalAccount();
}
