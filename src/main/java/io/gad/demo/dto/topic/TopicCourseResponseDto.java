package io.gad.demo.dto.topic;

import io.gad.demo.model.Course;

public class TopicCourseResponseDto {

	private Integer id;
	private String name;
	private String description;
	
	public TopicCourseResponseDto(Course course)
	{
		this.id = course.getId();
		this.name = course.getName();
		this.description = course.getDescription();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
