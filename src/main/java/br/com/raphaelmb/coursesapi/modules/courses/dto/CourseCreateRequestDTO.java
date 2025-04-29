package br.com.raphaelmb.coursesapi.modules.courses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateRequestDTO {
    @Schema(description = "Name of the course", example = "Spring Boot Course")
    private String name;
    
    @Schema(description = "Category of the course", example = "Programming")
    private String category;
}
