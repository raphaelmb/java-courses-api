package br.com.raphaelmb.coursesapi.modules.courses.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raphaelmb.coursesapi.modules.courses.dto.CourseCreateRequestDTO;
import br.com.raphaelmb.coursesapi.modules.courses.entity.CourseEntity;
import br.com.raphaelmb.coursesapi.modules.courses.repository.CourseRepository;

@Service
public class CreateCourseUseCase {
    @Autowired    
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseCreateRequestDTO courseCreateRequestDTO) {
        var course = new CourseEntity();
        course.setName(courseCreateRequestDTO.getName());
        course.setCategory(courseCreateRequestDTO.getCategory());
        course.setActive(true);

        return courseRepository.save(course);
    }
}
