package com.namratha.springboot.FirstApp.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.namratha.springboot.FirstApp.domain.Topic;
import com.namratha.springboot.FirstApp.exceptions.ResourceNotFoundException;
import com.namratha.springboot.FirstApp.services.TopicServiceImpl;

@RestController
public class TopicController {
	
	@Autowired
	private TopicServiceImpl topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable Long id) {
		return topicService.getTopicById(id);
	}
	
	@PostMapping("/topics")
	public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) throws ResourceNotFoundException {
		return new ResponseEntity<Topic>(topicService.createTopic(topic), HttpStatus.CREATED);
	}
	
	@PutMapping("/topics/{topicid}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable Long topicid) {
		topicService.updateTopic(topicid,topic);	 
	}
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable Long id) {
		 topicService.deleteTopic(id);
	}
}
