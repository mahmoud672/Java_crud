package io.gad.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.gad.demo.dto.course.CourseRequestDto;
import io.gad.demo.dto.course.CourseResponseDto;
import io.gad.demo.model.Course;
import io.gad.demo.service.CourseService;
import io.gad.demo.util.ApiResponse;
import io.gad.demo.validation.annotation.course.CourseIdExists;
import jakarta.validation.Valid;

@RestController
@Validated
public class CourseController {

	@Autowired
	private CourseService service;
	
	@GetMapping("/api/courses")
	public ResponseEntity<ApiResponse<List<CourseResponseDto>>> all()
	{
		List<Course> courses = service.getAllCourses();
		List<CourseResponseDto> courseList = courses.stream().map(CourseResponseDto::new).collect(Collectors.toList());
		ApiResponse<List<CourseResponseDto>> response = new ApiResponse<>("courses retrieved successfully.","success",200,courseList);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/api/courses/{id}")
	public ResponseEntity<ApiResponse<Course>> show(@PathVariable Integer id)
	{
		Course course = service.getCourse(id);
		ApiResponse<Course> response = new ApiResponse<Course>("course details retrieved successfully","success",200,course);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/api/courses")
	public ResponseEntity<ApiResponse<Void>> store(@Valid @RequestBody CourseRequestDto obj)
	{
		service.createCourse(obj);
		ApiResponse<Void> response = new ApiResponse<Void>("course created successfully","success",200, null);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/api/courses/{id}")
	public ResponseEntity<ApiResponse<Void>> destroy(@PathVariable @CourseIdExists Integer id)
	{
		service.deleteCourse(id);
		
		ApiResponse<Void> response = new ApiResponse<>("course deleted successfully","success",200, null);
		
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/api/courses/{id}")
	public ResponseEntity<ApiResponse<Void>> update(@Valid @RequestBody CourseRequestDto obj,@PathVariable Integer id)
	{
		service.updateCourse(obj,id);
		
		ApiResponse<Void> response = new ApiResponse<Void>("course updated successfully","success",200, null);
		
		return ResponseEntity.ok(response);
	}
	
	
}
