package com.hendisantika;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.net.URL;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestHTTPEndpoint(RegistrationResource.class)
public class RegistrationResourceTest {

    @TestHTTPResource
    @TestHTTPEndpoint(RegistrationResource.class)
    URL url;

    @InjectMock
    PasswordGenerator passwordGenerator;


}
