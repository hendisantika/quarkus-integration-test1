package com.hendisantika;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-integration-test1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/10/21
 * Time: 06.43
 */
@QuarkusTest
class PasswordGeneratorTest {
    @Inject
    PasswordGenerator passwordGenerator;

    @Test
    public void shouldGenerateARandomPassword() {
        final String password = passwordGenerator.generate();
        assertThat(password).containsPattern("[0-9A-F-]+");
    }
}
