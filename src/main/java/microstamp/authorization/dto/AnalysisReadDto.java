package microstamp.authorization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AnalysisReadDto {

    @NotBlank
    private String name;

    private String description;

    private Instant creationDate;

    @NotNull
    private UUID userId;

}
