package api;

import api.jupiter.BeforeAllApiTests;
import api.method.MethodGameController;
import api.method.MethodJwtAuthenticationController;
import api.method.MethodUserController;
import com.github.javafaker.Faker;


@BeforeAllApiTests
public class BaseApiTest {

    protected final MethodUserController userController = new MethodUserController();
    protected final MethodJwtAuthenticationController jwtAuthenticationController = new MethodJwtAuthenticationController();
    protected final MethodGameController gameController = new MethodGameController();
    protected final Faker faker = new Faker();


}
