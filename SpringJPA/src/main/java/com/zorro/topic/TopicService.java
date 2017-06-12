package com.zorro.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = (List<Topic>)new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring In Action","Excellent book on Spring"),
			new Topic("SCWCD","Web Component Developer","Excellent book on SCWCD"),
			new Topic("Struts","Struts In Action","Excellent book on Struts")
			));
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
		}
	
	
	public Topic getTopic(String id){		
		
		return topicRepository.findOne(id); 
		
	}
	
	public void addTopic(Topic topic)
	{
		topicRepository.save(topic);		
	}
	
	public void updateTopic(Topic topic, String id){		
		topicRepository.save(topic);
		
		
	}
	
	public void deleteTopic(String id){		
		topicRepository.delete(id);
		
		
	}
}
