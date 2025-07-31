package io.gad.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.gad.demo.dto.topic.TopicRequestDto;
import io.gad.demo.mapper.topic.TopicMapper;
import io.gad.demo.model.Topic;
import io.gad.demo.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;
	
	/**
	 * 
	 * @return
	 */
	public List<Topic> getTopics()
	{	
		return repository.findAll();
	}
	
	/**
	 * 
	 * @param courseId
	 * @return
	 */
	public List<Topic> getTopicsByCourseId(Integer courseId)
	{
		return repository.findAllByCourseId(courseId);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Topic getTopic(Integer id)
	{
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(Integer id)
	{
		repository.deleteById(id);
	}
	
	/**
	 * 
	 * @param obj
	 */
	public void createTopic(TopicRequestDto obj)
	{
		Topic topic = TopicMapper.fromDto(obj);
		repository.save(topic);
	}
	
	/**
	 * 
	 * @param obj
	 * @param id
	 */
	public void updateTopic(TopicRequestDto obj,Integer id)
	{
		Topic topic = TopicMapper.fromDto(obj,id); 
		//topic.setId(id);
		repository.save(topic);
	}
	
}
