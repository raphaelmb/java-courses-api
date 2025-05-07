package br.com.raphaelmb.coursesapi.modules.courses.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raphaelmb.coursesapi.modules.courses.repository.CourseRepository;

@Service
public class DeleteCourseUseCase {
    @Autowired
    private CourseRepository courseRepository; 

    public void execute(UUID id) {
        this.courseRepository.deleteById(id);
    }
}
