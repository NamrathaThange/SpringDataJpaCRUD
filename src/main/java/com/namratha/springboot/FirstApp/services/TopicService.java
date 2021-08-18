package com.namratha.springboot.FirstApp.services;

import java.util.List;

import com.namratha.springboot.FirstApp.domain.Topic;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;

public interface TopicService {

	public Topic createTopic(Topic topic) throws ResourceNotFoundException;
	
	public List<Topic> getAllTopics();
	
	public Topic getTopicById(Long topicId);
	
	public Topic updateTopic(Long topicId,Topic topic);
	
	public void deleteTopic(Long topicId);
	
}
