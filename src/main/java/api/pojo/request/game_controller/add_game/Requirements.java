package api.pojo.request.game_controller.add_game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Requirements {
    private Integer hardDrive;
    private String osName;
    private Integer ramGb;
    private String videoCard;

}
