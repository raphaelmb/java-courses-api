package br.com.raphaelmb.coursesapi.modules.courses.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raphaelmb.coursesapi.modules.courses.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID>{}