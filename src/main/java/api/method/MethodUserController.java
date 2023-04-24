package api.method;

import api.endpoint.EndpointUserController;
import api.helpers.ApiService;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;


public class MethodUserController {

    @Step("Метод post register")
    public void register(String name) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("login", name);
        body.put("pass", name);

        ApiService.postResponse(body, EndpointUserController.Post.register());

    }

    @Step("Метод delete userDelete")
    public Response userDelete(String token) {
        return ApiService.deleteResponse(token, EndpointUserController.Delete.user());
    }


    @Step("Метод get userGet")
    public Response userGet(String token) {
        return ApiService.getResponse(token, EndpointUserController.Get.user());
    }
}
