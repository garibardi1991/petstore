package api;

import api.helpers.Context;
import api.helpers.Generator;
import api.helpers.JsonMapper;
import api.pojo.request.game_controller.add_game.PojoReqAddGame;
import api.pojo.response.game_controller.add_game.PojoResAddGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.SAME_THREAD)
@Tag("api")
public class UserTests1 extends BaseApiTest {

//    private String token;

    private static String name;


    @BeforeEach
    public void registerUser() {
        name = Generator.generateRndName();
        userController.register(name);
        Context.token = jwtAuthenticationController.createAuthenticationToken(name);
    }

    @AfterEach
    public void deleteUser() {
        var message = userController.userDelete(Context.token).jsonPath().getString("info.message");
        assertThat(message).isEqualTo("User successfully deleted");
    }

    @Test
    public void newUser1() {
        var response = gameController.addGame(Context.token);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
        var login = userController.userGet(Context.token).jsonPath().get("login").toString();
        assertThat(name).isEqualTo(login);
    }

    @Test
    public void newUser2() {
        var body = JsonMapper.mapJsonToPojo("src/test/resources/files/game.json", PojoReqAddGame.class);
        var response = gameController.addGame(Context.token, body);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
        var login = userController.userGet(Context.token).jsonPath().get("login").toString();
        assertThat(name).isEqualTo(login);
    }

    @Test
    public void newUser3() {
        var body = JsonMapper.mapJsonToPojo("src/test/resources/files/game.json", PojoReqAddGame.class);
        var response = gameController.addGame(Context.token, body);
        var pojo = response.jsonPath().getObject("register_data", PojoResAddGame.class);
        var login = userController.userGet(Context.token).jsonPath().get("login").toString();
        assertThat(name).isEqualTo(login);
    }

}
