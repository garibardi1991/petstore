package api;

import api.method.MethodGameController;
import api.method.MethodJwtAuthenticationController;
import api.method.MethodUserController;
import api.spec.Specification;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    protected final MethodUserController userController = new MethodUserController();
    protected final MethodJwtAuthenticationController jwtAuthenticationController = new MethodJwtAuthenticationController();
    protected final MethodGameController gameController = new MethodGameController();
    protected final Faker faker = new Faker();

    @BeforeAll
    public static void setUp() {
        Specification.installSpecification200();
    }



}
