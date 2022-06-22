package com.unlilearning.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.unlilearning.model.Course;
import com.unlilearning.service.CourseService;

@Controller
public class CourseController {
	
	private CourseService service;
	
	
	@Autowired
	public CourseController(CourseService service) {
		this.service = service;
	}



	@GetMapping("/courses")
	public String displayCoursePage(Model model) {

		List<Course> coursesList = service.getCourses();
		
		Course.Type[] types = Course.Type.values();
		for (Course.Type type : types) {
			model.addAttribute(type.toString(),
					coursesList.stream().filter(course -> course.getType().equals(type)).collect(Collectors.toList()));
		}

		return "course/courses";
	}
}
