package api.pojo.response.game_controller.add_game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Dlcs {
    private String dlcName;
    private Boolean isDlcFree;
    private Integer price;
}
