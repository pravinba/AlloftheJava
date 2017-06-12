package com.zorro.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zorro.model.Topic;
import com.zorro.service.TopicService;


@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/topics",method=RequestMethod.GET)
	public List<Topic> getTopics()
	{
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value="/topics/{id}",method=RequestMethod.GET)
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value="/topics",method=RequestMethod.POST)
	public List<Topic> addTopic(@RequestBody Topic topic)
	{
		
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}",method=RequestMethod.PUT)
	public List<Topic> updateTopic(@RequestBody Topic topic,@PathVariable String id)
	{		
		return topicService.updateTopic(topic, id);
	}
}
