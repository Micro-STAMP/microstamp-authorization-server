package microstamp.authorization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AnalysisReadDto {

    @NotBlank
    private String name;

    private String description;

    private LocalDateTime creationDate;

    @NotNull
    private UUID userId;

}
