package api;

import api.helpers.JsonMapper;
import api.pojo.request.game_controller.add_game.PojoReqAddGame;
import api.pojo.response.game_controller.add_game.PojoResAddGame;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
public class UserTests2 extends BaseApiTest {


    public String registerUser() {
        String name = faker.name().firstName();
        userController.register(name);
        return jwtAuthenticationController.createAuthenticationToken(name);
    }


    public void deleteUser(String token) {
        var message = userController.userDelete(token).jsonPath().getString("info.message");
        assertThat(message).isEqualTo("User successfully deleted");
    }

    @Test
    public void newUser4() {
        var token = registerUser();
        var response = gameController.addGame(token);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
        deleteUser(token);
    }

    @Test
    public void newUser5() {
        var token = registerUser();
        var body = JsonMapper.mapJsonToPojo("src/test/resources/files/game.json", PojoReqAddGame.class);
        var response = gameController.addGame(token, body);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
        deleteUser(token);
    }

    @Test
    public void newUser6() {
        var token = registerUser();
        var body = JsonMapper.mapJsonToPojo("src/test/resources/files/game.json", PojoReqAddGame.class);
        var response = gameController.addGame(token, body);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
        deleteUser(token);
    }

}
