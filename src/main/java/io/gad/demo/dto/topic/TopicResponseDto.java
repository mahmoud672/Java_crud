package io.gad.demo.dto.topic;

import io.gad.demo.model.Course;
import io.gad.demo.model.Topic;

public class TopicResponseDto {

	private Integer id;
	private String name;
	private String description;
	private TopicCourseResponseDto course; 
	
	public TopicResponseDto(Topic topic)
	{
		this.id	= topic.getId();
		this.name = topic.getName();
		this.description = topic.getDescription();
		this.course = new TopicCourseResponseDto(topic.getCourse());
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	public void setCourseDto(TopicCourseResponseDto courseDto) {
		this.course = courseDto;
	}
	
	public TopicCourseResponseDto getCourse() {
		return course;
	}
	
}
