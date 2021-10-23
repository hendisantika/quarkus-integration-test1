package com.hendisantika;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-integration-test1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/10/21
 * Time: 06.48
 */
@QuarkusTest
public class UserTest {

    @Test
    @Transactional
    public void shouldFindUsersByUsername() {

        final User user = new User();
        user.username = "naruto";
        user.email = "naruto@example.com";

        user.persist();

        Optional<User> foundUser = User.findUserByUsername("naruto");

        assertThat(foundUser)
                .isNotEmpty()
                .map(u -> u.email)
                .contains("naruto@example.com");

    }

}
