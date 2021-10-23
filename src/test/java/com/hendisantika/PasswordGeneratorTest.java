package com.hendisantika;

import io.quarkus.test.junit.QuarkusTest;

import javax.inject.Inject;

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
}
