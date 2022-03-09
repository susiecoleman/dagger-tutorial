package atm.command.helpers;

import atm.PerSession;
import atm.command.withdraw.MaximumWithdrawal;
import java.math.BigDecimal;
import javax.inject.Inject;

@PerSession
public final class WithdrawalLimiter {
  private BigDecimal remainingWithdrawalLimit;

  @Inject
  public WithdrawalLimiter(@MaximumWithdrawal BigDecimal maximumWithdrawal) {
    this.remainingWithdrawalLimit = maximumWithdrawal;
  }

  public void recordDeposit(BigDecimal amount) {
    remainingWithdrawalLimit = remainingWithdrawalLimit.add(amount);
  }

  public void recordWithdrawal(BigDecimal amount) {
    remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount);
  }
}
