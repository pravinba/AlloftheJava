package com.zorro.topic.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
		
	public List<Course> getAllCourses(String id){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(courses::add);		
		return courses;
		}
	
	
	public Course getCourse(String id){		
		
		return courseRepository.findOne(id); 
		
	}
	
	public void addCourse(Course course)
	{
		/*System.out.println("Saving the course >>>>");
		System.out.println("Course ID:"+course.getTopic().getId());*/
		courseRepository.save(course);		
	}
	
	public void updateCourse(Course course){		
		courseRepository.save(course);
		
		
	}
	
	public void deleteCourse(String id){		
		courseRepository.delete(id);
		
		
	}
}
