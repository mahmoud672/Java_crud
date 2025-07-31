package io.gad.demo.mapper.topic;

import io.gad.demo.dto.topic.TopicRequestDto;
import io.gad.demo.model.Topic;

public class TopicMapper {

	public static Topic fromDto(TopicRequestDto dto)
	{
		return new Topic(dto.getName(),dto.getDescription(),dto.getCourseId());
	}

	public static Topic fromDto(TopicRequestDto dto,Integer id)
	{
		return new Topic(dto.getName(),dto.getDescription(),dto.getCourseId(),id);
	}
	
}
