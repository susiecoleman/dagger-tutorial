package atm.database;

import dagger.Binds;
import dagger.Module;

@Module
public interface InMemoryDatabaseModule {

  @Binds
  Database inMemory(InMemoryDatabase database);
}
