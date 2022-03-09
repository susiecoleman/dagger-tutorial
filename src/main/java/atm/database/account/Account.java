package atm.database.account;

import java.math.BigDecimal;

public interface Account {
  String username();

  void deposit(BigDecimal amount);

  void withdraw(BigDecimal amount);

  BigDecimal balance();
}
