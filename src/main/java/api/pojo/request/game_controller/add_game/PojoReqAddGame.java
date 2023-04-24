package api.pojo.request.game_controller.add_game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PojoReqAddGame {
    private String description;
    private String genre;
    private Boolean isFree;
    private Integer price;
    private Requirements requirements;
    private List<Dlcs> dlcs;

}
