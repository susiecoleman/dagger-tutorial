package atm;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Database {
  private final Map<String, Account> accounts = new HashMap<>();

  @Inject
  Database() {}

  public Account getAccount(String username) {
    return accounts.computeIfAbsent(username, Account::new);
  }

  public static final class Account {
    private String username;
    private BigDecimal balance = BigDecimal.ZERO;

    Account(String username) {
      this.username = username;
    }

    public String username() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public BigDecimal balance() {
      return balance;
    }

    public void setBalance(BigDecimal balance) {
      this.balance = balance;
    }
  }
}
