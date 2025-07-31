package io.gad.demo.mapper.course;

import io.gad.demo.dto.course.CourseRequestDto;
import io.gad.demo.model.Course;

public class CourseMapper {

	public static Course fromDto(CourseRequestDto dto)
	{
		return new Course(dto.getName(),dto.getDescription());
	}
	
	public static Course fromDto(CourseRequestDto dto,Integer id)
	{
		return new Course(dto.getName(),dto.getDescription(),id);
	}
}
