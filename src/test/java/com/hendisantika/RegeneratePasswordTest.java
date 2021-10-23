package com.hendisantika;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    public void shouldGenerateANewPassword() {
        Mockito.when(passwordGenerator.generate()).thenReturn("my_super_password").thenReturn("password");

        PanacheMock.mock(User.class);
        User user = new User("Naruto", "naruto@example.com", "my_super_password");
        Mockito.when(User.findUserByUsername("Alex")).thenReturn(Optional.of(user));

        regeneratePassword.regenerate("Naruto");

        PanacheMock.verify(User.class, Mockito.times(1)).findUserByUsername("Naruto");
        assertThat(user.password).isEqualTo("my_super_password");

    }

}
