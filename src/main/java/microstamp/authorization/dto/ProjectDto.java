package microstamp.authorization.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProjectDto {

    private String name;

    private String description;

    private UUID userExternalId;

}
