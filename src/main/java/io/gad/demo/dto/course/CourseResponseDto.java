package io.gad.demo.dto.course;

import java.util.List;
import java.util.stream.Collectors;

import io.gad.demo.model.Course;

public class CourseResponseDto {

	private Integer id;
	private String name;
	private String description;
	private List<CourseTopicResponseDto> topics;
	
	public CourseResponseDto(Course course)
	{
		this.setId(course.getId());
		this.setName(course.getName());
		this.setDescription(course.getDescription());
//		this.topics = course.getTopics().stream().map(topic -> new CourseResponseDto(topic)).collect(Collectors.toList());
		setTopics(
				course.getTopics().stream().map(CourseTopicResponseDto::new).collect(Collectors.toList())
				);
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CourseTopicResponseDto> getTopics() {
		return topics;
	}

	public void setTopics(List<CourseTopicResponseDto> topics) {
		this.topics = topics;
	}
	
}
