package api;

import api.method.MethodJwtAuthenticationController;
import api.method.MethodUserController;
import api.spec.Specification;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTests {

    private final MethodUserController userController = new MethodUserController();
    private final MethodJwtAuthenticationController jwtAuthenticationController = new MethodJwtAuthenticationController();

    @BeforeAll
    public static void setUp() {
        Specification.installSpecification200();
    }


    @Test
    public void newUser() {

        var faker = new Faker();
        String name = faker.name().firstName();

        userController.register(name);

        var token = jwtAuthenticationController.createAuthenticationToken(name);

        var message = userController.userDelete(token).jsonPath().getString("info.message");
        assertThat(message).isEqualTo("User successfully deleted");

    }


}
