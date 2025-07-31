package io.gad.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "course")
    private List<Topic> topics;

    public Course()
    {

    }

    public Course(String name,String description)
    {
        this.name = name;
        this.description = description;
    }

    public Course(String name,String description,Integer id)
    {
    	this.name = name;
    	this.description = description;
    	this.id = id;
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
    
    public List<Topic> getTopics()
    {
    	return topics;
    }
    public void setTopics(List<Topic> topics)
    {
    	this.topics = topics;
    }
}
