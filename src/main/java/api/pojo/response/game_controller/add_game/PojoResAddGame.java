package api.pojo.response.game_controller.add_game;

import api.pojo.request.game_controller.add_game.Requirements;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PojoResAddGame {
    private String description;
    private String genre;
    private Boolean isFree;
    private Integer price;
    private Requirements requirements;
    private List <Dlcs> dlcs;
    private Info info;

}
