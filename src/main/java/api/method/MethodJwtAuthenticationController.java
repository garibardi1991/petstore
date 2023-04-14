package api.method;

import api.endpoint.EndpointJwtAuthenticationController;
import io.qameta.allure.Step;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class MethodJwtAuthenticationController {

    @Step("Метод post createAuthenticationToken")
    public String createAuthenticationToken(String name) {
        HashMap<String,Object> body = new HashMap<>();
        body.put("password", name);
        body.put("username", name);

        return given()
                .body(body)
                .post(EndpointJwtAuthenticationController.Post.createAuthenticationToken())
                .then()
                .extract().response().jsonPath().getString("token");


    }
}
