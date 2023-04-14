package api;

import api.endpoint.EndpointJwtAuthenticationController;
import api.endpoint.EndpointUserController;
import api.spec.Specification;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserTests {

    @BeforeAll
    public static void setUp() {
        Specification.installSpecification200();
    }


    @Test
    public void newUser() {

        var faker = new Faker();
        String name = faker.name().firstName();

        HashMap<String,Object> body = new HashMap<>();
        body.put("login", name);
        body.put("pass", name);

        given()
                .body(body)
                .post(EndpointUserController.Post.register())
                .then();

        body.clear();
        body.put("password", name);
        body.put("username", name);

        var response = given()
                .body(body)
                .post(EndpointJwtAuthenticationController.Post.createAuthenticationToken())
                .then()
                .extract().response();

        var token = response.jsonPath().getString("token");
        System.out.println(token);

        given()
                .auth().oauth2(token)
                .delete(EndpointUserController.Delete.user())
                .then();

    }

    @Test
    public void newUser2() {

        var faker = new Faker();
        String name = faker.name().firstName();

        HashMap<String,Object> body = new HashMap<>();
        body.put("login", name);
        body.put("pass", name);

        given()
                .body(body)
                .post(EndpointUserController.Post.register())
                .then();

        body.clear();
        body.put("password", name);
        body.put("username", name);

        var response = given()
                .body(body)
                .post(EndpointJwtAuthenticationController.Post.createAuthenticationToken())
                .then()
                .extract().response();

        var token = response.jsonPath().getString("token");
        System.out.println(token);

        given()
                .auth().oauth2(token)
                .delete(EndpointUserController.Delete.user())
                .then();

    }
}
