package valorant.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapRequest {

    @NotBlank
    private String name;

}
