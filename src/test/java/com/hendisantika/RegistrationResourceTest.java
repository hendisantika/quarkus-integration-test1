package com.hendisantika;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestHTTPEndpoint(RegistrationResource.class)
public class RegistrationResourceTest {

    @TestHTTPResource
    @TestHTTPEndpoint(RegistrationResource.class)
    URL url;

    @InjectMock
    PasswordGenerator passwordGenerator;

    @Test
    @Order(1)
    public void shouldRegisterAUser() {

        Mockito.when(passwordGenerator.generate()).thenReturn("my-secret-password");

        final User user = new User();
        user.username = "naruto";
        user.email = "naruto@example.com";

        given()
                .body(user)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().post()
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .header("location", url + "/1");
    }

    @Test
    @Order(2)
    public void shouldFindAUserByUsername() throws InterruptedException {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().get("/{username}", "naruto")
                .then()
                .statusCode(200)
                .body("username", is("naruto"))
                .body("email", is("naruto@example.com"))
                .body("password", is("my-secret-password"));
    }

}
