package atm.router;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

@Retention(RUNTIME)
@Qualifier
@Documented
public @interface Username {}
