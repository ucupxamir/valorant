package valorant.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import valorant.api.entities.generics.AgentRole;

@Getter
@Setter
public class AgentRequest {

    @NotBlank
    private String name;

    @NotNull
    private AgentRole role;

}
