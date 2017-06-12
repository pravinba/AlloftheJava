package com.zorro.topic.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String>{
	
	public Course findById(String name);
	public List<Course> findByDescription(String name);
	public List<Course> findByTopicId(String topic);
	

}
