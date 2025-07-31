package io.gad.demo.dto.topic;

import io.gad.demo.validation.annotation.course.CourseIdExists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TopicRequestDto {

	@NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name can have at most 100 characters")
	private String name;
	@NotBlank(message = "Description is required")
	private String description;
	@NotNull
	@CourseIdExists
	private Integer courseId;
	
	public TopicRequestDto()
	{
		
	}
	public TopicRequestDto(String name,String description,Integer courseId)
	{
		this.setName(name);
		this.setDescription(description);
		this.setCourseId(courseId);
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

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}
