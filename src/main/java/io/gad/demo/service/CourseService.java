package io.gad.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.gad.demo.dto.course.CourseRequestDto;
import io.gad.demo.mapper.course.CourseMapper;
import io.gad.demo.model.Course;
import io.gad.demo.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	
	public List<Course> getAllCourses()
	{
		return repository.findAll();
	}
	
	public Course getCourse(Integer id)
	{
		return repository.findById(id).orElseThrow(() -> new RuntimeException("course not found"));
	}
	
	public void createCourse(CourseRequestDto obj)
	{
		Course course = CourseMapper.fromDto(obj);
		repository.save(course);
	}
	
	public void updateCourse(CourseRequestDto obj,Integer id)
	{
		
//		  Course course = new Course(); course.setId(id);
//		  course.setName(obj.getName()); course.setDescription(obj.getDescription());
//		  
//		  repository.save(course);
		Course course = CourseMapper.fromDto(obj,id);
		  course.setId(id);
		  repository.save(course);
		 
	}
	
	public void deleteCourse(Integer id)
	{
		if(repository.existsById(id))
		{
			repository.deleteById(id);
		}
		
	}
	
}
