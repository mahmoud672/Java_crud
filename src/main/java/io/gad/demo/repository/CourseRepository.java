package io.gad.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import io.gad.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public void deleteById(Integer id);
}
