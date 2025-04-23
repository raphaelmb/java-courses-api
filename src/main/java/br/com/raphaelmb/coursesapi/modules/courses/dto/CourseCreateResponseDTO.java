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
    private UUID id;

    @Schema(example = "Java Course")
    private String name;

    @Schema(example = "Backend")
    private String category;
}
