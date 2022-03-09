package atm.database.account;

import atm.database.Database;
import atm.router.Username;
import dagger.Module;
import dagger.Provides;

@Module
public interface AccountModule {
  @Provides
  static Account account(Database database, @Username String username) {
    return database.getAccount(username);
  }
}
