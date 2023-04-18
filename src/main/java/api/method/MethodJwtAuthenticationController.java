package api.method;

import api.endpoint.EndpointJwtAuthenticationController;
import api.helpers.ApiService;
import io.qameta.allure.Step;

import java.util.HashMap;

public class MethodJwtAuthenticationController {

    @Step("Метод post createAuthenticationToken")
    public String createAuthenticationToken(String name) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("password", name);
        body.put("username", name);


        return ApiService.postJsonPathGetString(
                body,
                EndpointJwtAuthenticationController.Post.createAuthenticationToken(),
                "token"
        );

    }
}
