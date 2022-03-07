package atm.commands;

import atm.commands.deposit.DepositCommand;
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
}
