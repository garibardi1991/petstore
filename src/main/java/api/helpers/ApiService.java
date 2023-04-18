package api.helpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiService {

    @Step("Post {endpoint}")
    public static Response postResponse (Object body, String endpoint) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().response();
    }

    @Step("Delete {endpoint}")
    public static Response deleteResponse (String token, String endpoint) {
        return given()
                .auth().oauth2(token)
                .delete(endpoint)
                .then()
                .extract().response();
    }

    @Step("Post {endpoint} {jsonPath}")
    public static String postJsonPathGetString (Object body, String endpoint, String jsonPath) {
        return given()
                .body(body)
                .post(endpoint)
                .then()
                .extract().response().jsonPath().getString(jsonPath);
    }

    @Step("Post {endpoint}")
    public static Response postResponse (String token, Object body, String endpoint) {
        return given()
                .auth().oauth2(token)
                .body(body)
                .post(endpoint)
                .then()
                .extract().response();
    }

}
