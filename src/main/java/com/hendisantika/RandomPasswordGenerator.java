package com.hendisantika;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-integration-test1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/10/21
 * Time: 06.39
 */
@ApplicationScoped
public class RandomPasswordGenerator implements PasswordGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
