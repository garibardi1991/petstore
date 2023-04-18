package api;

import api.pojo.response.game_controller.add_game.PojoResAddGame;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTests extends BaseApiTest {

    @Test
    public void newUser() {
        String name = faker.name().firstName();
        userController.register(name);
        var token = jwtAuthenticationController.createAuthenticationToken(name);
        var response = gameController.addGame(token);
        var pojo = response.as(PojoResAddGame.class);
        var message = userController.userDelete(token).jsonPath().getString("info.message");
        assertThat(message).isEqualTo("User successfully deleted");

    }



}
