package atm.command.usercommands;

import atm.command.Command;
import atm.command.usercommands.deposit.DepositCommand;
import atm.command.usercommands.logout.LogoutCommand;
import atm.command.usercommands.withdraw.WithdrawCommand;
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
