package br.com.raphaelmb.coursesapi.modules.courses.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raphaelmb.coursesapi.modules.courses.entity.CourseEntity;
import br.com.raphaelmb.coursesapi.modules.courses.repository.CourseRepository;

@Service
public class GetAllCoursesUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        return this.courseRepository.findAll();
    }
}
