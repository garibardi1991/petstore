package api.method;

import api.endpoint.EndpointUserController;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class MethodUserController {

    @Step ("Метод post register")
    public void register(String name) {
        HashMap<String,Object> body = new HashMap<>();
        body.put("login", name);
        body.put("pass", name);

        given()
                .body(body)
                .post(EndpointUserController.Post.register())
                .then();
    }

    @Step ("Метод delete userDelete")
    public Response userDelete(String token) {
        return given()
                .auth().oauth2(token)
                .delete(EndpointUserController.Delete.user())
                .then()
                .extract().response();

    }

}
