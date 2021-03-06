package com.namratha.springboot.FirstApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namratha.springboot.FirstApp.constants.MessageConstant;
import com.namratha.springboot.FirstApp.domain.Topic;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.repositaries.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicRepository topicRepository;

	@Override
	public Topic createTopic(Topic topic) throws ResourceNotFoundException {
		findByTechnologyName(topic.getTechnologyName());
		return topicRepository.save(topic);
	}

	@Override
	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
	}

	@Override
	public Topic getTopicById(Long topicId) throws ResourceNotFoundException {
		return findById(topicId);
	}

	@Override
	public Topic updateTopic(Long topicId, Topic updatedTopicInfo) throws ResourceNotFoundException {
		Topic topic = findById(topicId);
		topic.setTechnologyName(updatedTopicInfo.getTechnologyName());
		topic.setTechnologyDescription(updatedTopicInfo.getTechnologyDescription());
		return topicRepository.save(topic);
	}

	@Override
	public void deleteTopic(Long topicId) throws ResourceNotFoundException {
		topicRepository.delete(findById(topicId));
	}

	private Topic findByTechnologyName(String topicName) throws ResourceNotFoundException {
		Topic topic = topicRepository.findByTechnologyName(topicName);
		if (topic != null) {
			String errorInfo = topicName + MessageConstant.ALREADY_EXISTS ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return topic;
	}

	private Topic findById(Long id) throws ResourceNotFoundException {
		Optional<Topic> optionalTopicObject = topicRepository.findById(id);
		if (!optionalTopicObject.isPresent()) {
			String errorInfo = MessageConstant.NOT_FOUND + id ;
			throw new ResourceNotFoundException(errorInfo);
		}
		return optionalTopicObject.get();

	}

}
