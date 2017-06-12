package com.zorro.topic.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.zorro.topic.Topic;

@Entity
public class Course {
	@Id
	private String id;
	private String name;
	private String description;
	
	@ManyToOne
	private Topic topic;
	
	public String getId() {
		return id;
	}
	
	public Course() {
		
	}
	
	public Course(String id, String name, String description,String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId,"","");
		//System.out.println("Setting up Course Constructor"+topic.getId());
		
	}
	
	

	public void setTopic(Topic topic) {
		this.topic = topic;
		//System.out.println("Setting up Topic Object(2)"+topic.getId());
	}

	public Topic getTopic() {
		return topic;
	}

	public void setId(String id) {
		this.id = id;
		//System.out.println("Setting up Course Id "+this.getId());
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
		//System.out.println("Setting up Course Name "+this.getName());
	}
	public String getDescription() {		
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		//System.out.println("Setting up Course Desc "+this.getDescription());
	}

	
	
	

}
