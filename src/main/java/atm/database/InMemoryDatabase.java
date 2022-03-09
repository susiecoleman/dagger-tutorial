package atm.database;

import atm.database.account.Account;
import atm.database.account.InMemoryAccount;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class InMemoryDatabase implements Database {
  private final Map<String, Account> accounts = new HashMap<>();

  @Inject
  InMemoryDatabase() {}

  @Override
  public Account getAccount(String username) {
    return accounts.computeIfAbsent(username, InMemoryAccount::new);
  }
}
