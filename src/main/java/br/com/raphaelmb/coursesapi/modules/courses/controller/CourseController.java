package br.com.raphaelmb.coursesapi.modules.courses.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raphaelmb.coursesapi.modules.courses.dto.CourseCreateRequestDTO;
import br.com.raphaelmb.coursesapi.modules.courses.dto.CourseCreateResponseDTO;
import br.com.raphaelmb.coursesapi.modules.courses.dto.CourseUpdateDTO;
import br.com.raphaelmb.coursesapi.modules.courses.entity.CourseEntity;
import br.com.raphaelmb.coursesapi.modules.courses.usecases.CreateCourseUseCase;
import br.com.raphaelmb.coursesapi.modules.courses.usecases.DeleteCourseUseCase;
import br.com.raphaelmb.coursesapi.modules.courses.usecases.GetAllCoursesUseCase;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private GetAllCoursesUseCase getAllCoursesUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;
    
    @GetMapping("/")
    public ResponseEntity<List<CourseEntity>> listCourses() {
        var courses = this.getAllCoursesUseCase.execute();

        return ResponseEntity.ok().body(courses);
    }

    @PostMapping("/")
    public ResponseEntity<CourseCreateResponseDTO> createCourse(@RequestBody CourseCreateRequestDTO courseCreateRequestDTO) {
        var course = this.createCourseUseCase.execute(courseCreateRequestDTO);

        var createdCourseDTO = CourseCreateResponseDTO.builder()
            .category(course.getCategory())
            .id(course.getId())
            .name(course.getName())
            .build();
        
        return ResponseEntity.status(201).body(createdCourseDTO);
    }

    @PutMapping("/{id}")
    public String updateCourse(@PathVariable UUID id, @RequestBody CourseUpdateDTO courseUpdateDTO) {
        return "Course updated";
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable UUID id) {
        this.deleteCourseUseCase.execute(id);

        return ResponseEntity.status(200).build();
    }   

    @PatchMapping("/{id}/active")
    public String updateCourseActive(@PathVariable UUID id, @RequestBody boolean active) {
        return "Course active updated";
    }
}
