package com.unlilearning.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unlilearning.model.Course;
import com.unlilearning.service.CourseService;

@Controller
public class HomeController {

	private CourseService service;

	@Autowired
	public HomeController(CourseService service) {
		this.service = service;
	}

	@RequestMapping(value = { "", "/", "home" })
	public String displayHome(Model model) {

		List<Course> coursesList = service.getCourses();

		Course.Type[] types = Course.Type.values();
		for (Course.Type type : types) {
			model.addAttribute(type.toString(),
					coursesList.stream().filter(course -> course.getType().equals(type)).collect(Collectors.toList()));
		}

		return "home";
	}
}
