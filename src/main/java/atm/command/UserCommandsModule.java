package atm.command;

import atm.command.deposit.DepositCommand;
import atm.command.logout.LogoutCommand;
import atm.command.withdraw.WithdrawCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class UserCommandsModule {
  @Binds
  @IntoMap
  @StringKey("deposit")
  abstract Command depositCommand(DepositCommand command);

  @Binds
  @IntoMap
  @StringKey("withdraw")
  abstract Command withdrawCommand(WithdrawCommand command);

  @Binds
  @IntoMap
  @StringKey("logout")
  abstract Command logoutCommand(LogoutCommand command);
}
