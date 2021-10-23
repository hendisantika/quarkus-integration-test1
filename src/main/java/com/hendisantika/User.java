package com.hendisantika;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-integration-test1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/10/21
 * Time: 06.38
 */
@Entity
public class User extends PanacheEntity {
    @Column
    public String username;
    @Column
    public String email;
    @Column
    public String password;

    public User() {
        super();
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static Optional<User> findUserByUsername(String username) {
        return find("username", username).firstResultOptional();
    }
}
