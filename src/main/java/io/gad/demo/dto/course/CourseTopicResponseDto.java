package io.gad.demo.dto.course;

import io.gad.demo.model.Topic;

public class CourseTopicResponseDto {

	private Integer id;
	private String name;
	private String description;
	
	public CourseTopicResponseDto(Topic topic)
	{
		this.id = topic.getId();
		this.name = topic .getName();
		this.description = topic.getDescription();
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
