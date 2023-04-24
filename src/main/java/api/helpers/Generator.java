package api.helpers;

import com.github.javafaker.Faker;

import java.time.Instant;

public class Generator {

    private static final Faker faker = new Faker();

    public static String generateRndName() {
        return faker.name().firstName() + Instant.now().getEpochSecond();
    }

}
