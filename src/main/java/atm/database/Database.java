package atm.database;

import atm.database.account.Account;

public interface Database {
  Account getAccount(String username);
}
