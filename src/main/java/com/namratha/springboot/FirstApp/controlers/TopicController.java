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
	
	@PostMapping("/topics")
	public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) throws ResourceNotFoundException {
		return new ResponseEntity<Topic>(topicService.createTopic(topic), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Topic>> getAllTopics() {
		return new ResponseEntity<List<Topic>>(topicService.getAllTopics(), HttpStatus.OK);
	}
	
	@GetMapping("/topics/{id}")
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<Topic>(topicService.getTopicById(id), HttpStatus.OK);
	}
	
	@PutMapping("/topics/{topicid}")
	public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic,@PathVariable Long topicid) throws ResourceNotFoundException {
		return new ResponseEntity<Topic>(topicService.updateTopic(topicid,topic), HttpStatus.OK);
	}
	
	@DeleteMapping("/topics/{id}")
	public ResponseEntity<String> deleteTopic(@PathVariable("id") Long id) throws ResourceNotFoundException {
		topicService.deleteTopic(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
}
