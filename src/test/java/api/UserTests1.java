package api;

import api.helpers.JsonMapper;
import api.pojo.request.game_controller.add_game.PojoReqAddGame;
import api.pojo.response.game_controller.add_game.PojoResAddGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api")
public class UserTests1 extends BaseApiTest {

    private String token;

    @BeforeEach
    public void registerUser (){
        String name = faker.name().firstName();
        userController.register(name);
        this.token = jwtAuthenticationController.createAuthenticationToken(name);
    }

    @AfterEach
    public void deleteUser () {
        var message = userController.userDelete(token).jsonPath().getString("info.message");
        assertThat(message).isEqualTo("User successfully deleted");
    }

    @Test
    public void newUser1() {
        var response = gameController.addGame(token);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
    }

    @Test
    public void newUser2() {
        var body = JsonMapper.mapJsonToPojo("src/test/resources/files/game.json", PojoReqAddGame.class);
        var response = gameController.addGame(token, body);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
    }

    @Test
    public void newUser3() {
        var body = JsonMapper.mapJsonToPojo("src/test/resources/files/game.json", PojoReqAddGame.class);
        var response = gameController.addGame(token, body);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
    }

}
