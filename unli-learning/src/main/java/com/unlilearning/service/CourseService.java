package com.unlilearning.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unlilearning.model.Course;

@Service
public class CourseService {

	public List<Course> getCourses(){
		List<Course> coursesList = Arrays.asList(
				new Course("Java Programming", "Build Java Applications using Java", "http:link.com", Course.Type.PROD),
				new Course("SQL Programming", "Build statements using SQL", "http:link.com", Course.Type.PROD),
				new Course("Python Programming", "Build applications using python", "http:link.com", Course.Type.DRAFT),
				new Course("C Programming", "Build complex apps using C", "http:link.com", Course.Type.PROD));
		return coursesList;
	}
}
