package com.hendisantika;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

import javax.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-integration-test1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/10/21
 * Time: 06.45
 */
@QuarkusTest
public class RegeneratePasswordTest {

    @InjectMock
    PasswordGenerator passwordGenerator;

    @Inject
    RegeneratePassword regeneratePassword;


}
