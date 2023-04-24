package api.method;

import api.endpoint.EndpointGameController;
import api.helpers.ApiService;
import api.pojo.request.game_controller.add_game.Dlcs;
import api.pojo.request.game_controller.add_game.PojoReqAddGame;
import api.pojo.request.game_controller.add_game.Requirements;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;


public class MethodGameController {

    @Step("Method Post addGame")
    public Response addGame(String token) {
        var requirements = Requirements.builder()
                .ramGb(20)
                .osName("Witcher")
                .hardDrive(50)
                .videoCard("NVIDIA")
                .build();

        var dlcs1 = Dlcs.builder()
                .price(30)
                .dlcName("Убийца Королей")
                .isDlcFree(false)
                .build();

        var dlcs2 = Dlcs.builder()
                .price(30)
                .dlcName("Кровь и Вино")
                .isDlcFree(false)
                .build();

        List<Dlcs> dlcs = new ArrayList<>();
        dlcs.add(dlcs1);
        dlcs.add(dlcs2);

        var body = PojoReqAddGame.builder()
                .price(100)
                .genre("rpg")
                .description("Ведьмак 2")
                .isFree(false)
                .dlcs(dlcs)
                .requirements(requirements)
                .build();


        return ApiService.postResponse(token, body, EndpointGameController.Post.addGame());
    }

    @Step("Method Post addGame")
    public Response addGame(String token, Object body) {


        return ApiService.postResponse(token, body, EndpointGameController.Post.addGame());
    }
}
