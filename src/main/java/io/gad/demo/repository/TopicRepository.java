package io.gad.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.gad.demo.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer>{

	public void deleteById(Integer id);
	public List<Topic> findAllByCourseId(Integer courseId);
}
