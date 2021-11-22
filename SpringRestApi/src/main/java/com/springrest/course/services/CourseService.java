package com.springrest.course.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.course.entity.Courses;

@Service
public interface CourseService {
	
	public List<Courses> getCourses();
	
	public Courses getCourse(long courseId);
	
	public Courses addCourse(Courses course);
	
	public void deleteCourse(long courseId);
	
	public Courses updateCourse(Courses course);

}
