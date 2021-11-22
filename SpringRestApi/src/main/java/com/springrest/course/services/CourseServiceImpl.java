package com.springrest.course.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.course.dao.CourseDAO;
import com.springrest.course.entity.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDao;	
	
	@Override
	public List<Courses> getCourses() {
		return courseDao.findAll();
	}

	//@SuppressWarnings("deprecation")
	@Override
	public Courses getCourse(long courseId) {
		return courseDao.findById(courseId).get();
	}

	@Override
	public Courses addCourse(Courses course) {
		courseDao.save(course);		
		return course;
	}
	
	@Override
	public Courses updateCourse(Courses course)
	{
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		Courses course = courseDao.findById(courseId).get();
		courseDao.delete(course);
	}

}
