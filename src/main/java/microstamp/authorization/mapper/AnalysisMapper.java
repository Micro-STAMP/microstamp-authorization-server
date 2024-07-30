package microstamp.authorization.mapper;

import microstamp.authorization.dto.AnalysisReadDto;
import microstamp.authorization.entity.Analysis;

public class AnalysisMapper {

    public static AnalysisReadDto toDto(Analysis analysis) {
        return new AnalysisReadDto(analysis.getName(),
                analysis.getDescription(),
                analysis.getCreatedAt(),
                analysis.getUser().getId());
    }
}
