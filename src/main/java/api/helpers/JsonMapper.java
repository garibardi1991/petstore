package api.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class JsonMapper {

    private final static ObjectMapper objectMapper = new ObjectMapper();


    @SneakyThrows
    public static <T> T mapJsonToPojo(String path, Class<T> pojo) {
        return objectMapper.readValue(new File(path), pojo);
    }

}
