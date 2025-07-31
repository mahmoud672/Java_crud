package io.gad.demo.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CourseRequestDto {

	@NotBlank
	private String name;
	@NotBlank
	@Size(min = 10,message = "description characters length must be at least 10 characters")
	private String description;
	
	public CourseRequestDto()
	{
		
	}
	
	public CourseRequestDto(String name,String description)
	{
		this.setName(name);
		this.setDescription(description);
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
