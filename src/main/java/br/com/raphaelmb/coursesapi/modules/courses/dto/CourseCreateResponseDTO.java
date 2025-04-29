package br.com.raphaelmb.coursesapi.modules.courses.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateResponseDTO {
    @Schema(example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(example = "Java Course")
    private String name;

    @Schema(example = "Backend")
    private String category;
}
