package com.hendisantika;

import io.quarkus.test.junit.NativeImageTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;

@NativeImageTest
public class NativeRegistrationResourceIT extends RegistrationResourceTest {

    @Test
    public void shouldRegisterAUser() {

        final User user = new User();
        user.username = "naruto";
        user.email = "naruto@example.com";

        given()
                .body(user)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().post()
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode());
    }
}
