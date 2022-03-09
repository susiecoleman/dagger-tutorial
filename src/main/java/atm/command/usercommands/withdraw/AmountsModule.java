package atm.command.usercommands.withdraw;

import dagger.Module;
import dagger.Provides;
import java.math.BigDecimal;

@Module
public abstract class AmountsModule {

  @Provides
  @MinimumBalance
  static BigDecimal minimumBalance() {
    return BigDecimal.ZERO;
  }

  @Provides
  @MaximumWithdrawal
  static BigDecimal maximumWithdrawal() {
    return new BigDecimal(1000);
  }
}
