package com.hendisantika;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

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

    @Transactional
    public void regenerate(String username) {

        final Optional<User> user = User.findUserByUsername(username);
        user.map(u -> {
            String newPassword = passwordGenerator.generate();
            u.password = newPassword;
            return u;
        });

    }
}
