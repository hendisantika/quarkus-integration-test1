package com.hendisantika;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-integration-test1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/10/21
 * Time: 06.40
 */
@ApplicationScoped
public class RegeneratePassword {

    @Inject
    PasswordGenerator passwordGenerator;
}
