package com.namratha.springboot.FirstApp.repositaries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namratha.springboot.FirstApp.domain.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic , Long> {

	Topic findByName(String topicName);

}
