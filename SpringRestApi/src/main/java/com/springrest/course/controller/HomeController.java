package com.springrest.course.controller;

import java.util.List;

import javax.annotation.PostConstruct;

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

import com.springrest.course.entity.Courses;
import com.springrest.course.services.CourseService;

@RestController
public class HomeController {
	
	@Autowired
	private CourseService courseService; 
	
	@GetMapping("/home")
	public String home()
	{
		return "THIS is Home";
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Courses>> getCourses()
	{
		try {
			return new ResponseEntity<List<Courses>>(courseService.getCourses(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Courses> getCourse(@PathVariable String courseId )
	{
		try {
			return new ResponseEntity<Courses>(courseService.getCourse(Long.valueOf(courseId)),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Courses> addCourse(@RequestBody Courses course)
	{
		try {
			return new ResponseEntity<Courses>(courseService.addCourse(course),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Courses> updateCourse(@RequestBody Courses course)
	{
		try {
			return new ResponseEntity<Courses>(courseService.updateCourse(course), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
