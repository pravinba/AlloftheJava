package com.zorro.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zorro.model.Topic;

@Service
public class TopicService {
	
	private List<Topic> topics = (List<Topic>)new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring In Action","Excellent book on Spring"),
			new Topic("SCWCD","Web Component Developer","Excellent book on SCWCD"),
			new Topic("Struts","Struts In Action","Excellent book on Struts")
			));
	
	public List<Topic> getAllTopics(){
		
		return topics;
	}
	
	
	public Topic getTopic(String id){
		
		System.out.println(topics.stream().filter(t -> t.getId().equals(id)).findFirst().get());
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}
	
	public List<Topic> addTopic(Topic topic)
	{
		topics.add(topic);
		return topics;
	}
	
	public List<Topic> updateTopic(Topic topic, String id){
		
		/*if(topics.stream().filter(t -> t.getId().equals(id)).findFirst().get() != null)
		{*/
			for(int i=0;i<topics.size();i++)
			{
				Topic t = topics.get(i);
				if(t.getId().equals(id))
				{
					System.out.println(topics.get(i).getName());
					topics.set(i, topic);
				}
			}
		
		
		return topics;
		
	}
}
