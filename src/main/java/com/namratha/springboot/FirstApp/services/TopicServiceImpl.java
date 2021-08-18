package com.namratha.springboot.FirstApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namratha.springboot.FirstApp.domain.Topic;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.repositaries.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Override
	public Topic createTopic (Topic topic) throws ResourceNotFoundException {
		getTopicByName(topic.getName());
		return topicRepository.save(topic);
	}

	@Override
	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
	}

	@Override
	public Topic getTopicById(Long topicId) {
		return topicRepository.findById(topicId).get();
	}

	@Override
	public Topic updateTopic(Long topicId,Topic topic) {
		return topicRepository.save(topic);
	}

	@Override
	public void deleteTopic(Long topicId) {
		topicRepository.deleteById(topicId);;
	}
	
	private Topic getTopicByName(String topicName) throws ResourceNotFoundException {
		Topic topic = topicRepository.findByName(topicName);
		if(topic != null) {
			String errorInfo = "Given name exists or in use " + topicName + ". ";
			throw new ResourceNotFoundException(errorInfo);
		}
		return topic;
	}
	
	
}
