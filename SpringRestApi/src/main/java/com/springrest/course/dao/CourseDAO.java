package com.springrest.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.course.entity.Courses;

public interface CourseDAO extends JpaRepository<Courses, Long> {

}
