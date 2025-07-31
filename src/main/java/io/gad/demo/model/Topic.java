package io.gad.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	@Column(name = "course_id")
	//@JsonIgnore
	private Integer courseId;
	
	@ManyToOne
	@JoinColumn(name = "course_id",insertable = false,updatable = false)
	@JsonIgnore
	private Course course;
	
	public Topic()
	{
		
	}
	
	public Topic(String name,String description,Integer courseId)
	{
		this.name = name;
		this.description = description;
		this.courseId = courseId;
	}
	public Topic(String name,String description,Integer courseId,Integer id)
	{
		this.name = name;
		this.description = description;
		this.courseId = courseId;
		this.id = id;
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
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Course getCourse()
	{
		return this.course;
	}
	
	public void setCourse(Course course)
	{
		this.course = course;
	}
	
}
