package io.gad.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gad.demo.dto.course.CourseTopicResponseDto;
import io.gad.demo.dto.topic.TopicRequestDto;
import io.gad.demo.dto.topic.TopicResponseDto;
import io.gad.demo.model.Topic;
import io.gad.demo.service.TopicService;
import io.gad.demo.util.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/topics")
public class TopicController {

	@Autowired
	private TopicService service;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<TopicResponseDto>>> all()
	{
		List<Topic> topics = service.getTopics();
		List<TopicResponseDto> topicResponseDto = topics.stream().map(TopicResponseDto::new).collect(Collectors.toList());
		//return service.getTopics();
		ApiResponse<List<TopicResponseDto>> response = new ApiResponse<List<TopicResponseDto>>("topics retrieved successfully","success",200, topicResponseDto);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<TopicResponseDto>> getTopic(@PathVariable Integer id)
	{
		Topic topic = service.getTopic(id);
		ApiResponse<TopicResponseDto> response = new ApiResponse<TopicResponseDto>("topic retrieved successfully","success",200, new TopicResponseDto(topic));
			return ResponseEntity.ok(response);
	}
	
//	@GetMapping("/course/{courseId}")
//	public List<Topic> getAllByCourseId(@PathVariable Integer courseId)
//	{
//		return service.getTopicsByCourseId(courseId);
//	}
	@GetMapping("/course/{courseId}")
	public ResponseEntity<ApiResponse<List<CourseTopicResponseDto>>> getAllByCourseId(@PathVariable Integer courseId)
	{
		List<Topic> topics = service.getTopicsByCourseId(courseId); 
		List<CourseTopicResponseDto> courseTopicDto = topics.stream().map(CourseTopicResponseDto::new).collect(Collectors.toList());
		ApiResponse<List<CourseTopicResponseDto>> response = new ApiResponse<List<CourseTopicResponseDto>>("topics retrieved successfully","success",200, courseTopicDto);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public  ResponseEntity<ApiResponse<Void>> store(@Valid @RequestBody TopicRequestDto obj)
	{
		//System.out.println(obj.getCourseId());
		service.createTopic(obj);
		ApiResponse<Void> response = new ApiResponse<>("topic created successfully","success",200, null);
		 return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> update(@RequestBody TopicRequestDto obj,@PathVariable Integer id)
	{
		service.updateTopic(obj, id);
		ApiResponse<Void> response = new ApiResponse<Void>("topic updated successfully","success", 200, null);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> destroy(@PathVariable Integer id)
	{
		service.delete(id);
		ApiResponse<Void> response = new ApiResponse<Void>("topic deleted successfully","success",200, null);
		return ResponseEntity.ok(response);
	}
	
}
