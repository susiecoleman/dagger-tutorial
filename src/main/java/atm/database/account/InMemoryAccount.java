package atm.database.account;

import java.math.BigDecimal;
import javax.inject.Inject;

public class InMemoryAccount implements Account {
  private final String username;
  private BigDecimal balance = BigDecimal.ZERO;

  @Inject
  public InMemoryAccount(String username) {
    this.username = username;
  }

  @Override
  public String username() {
    return username;
  }

  @Override
  public void deposit(BigDecimal amount) {
    checkNonNegative(amount, "deposit");
    balance = balance.add(amount);
  }

  @Override
  public void withdraw(BigDecimal amount) {
    checkNonNegative(amount, "withdraw");
    balance = balance.subtract(amount);
  }

  private void checkNonNegative(BigDecimal amount, String action) {
    if (amount.signum() == -1) {
      throw new IllegalArgumentException(
          String.format("Cannot %s negative amounts: %s", action, amount));
    }
  }

  @Override
  public BigDecimal balance() {
    return balance;
  }
}
