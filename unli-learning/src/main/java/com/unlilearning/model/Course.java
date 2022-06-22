package com.unlilearning.model;


public class Course {

	private final String courseName;
	private final String courseDescription;
	private final String link;
	private final Type type;

	public enum Type {
		DRAFT, PROD
	}
	
	

	public Course(String courseName, String courseDescription, String link, Type type) {
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.link = link;
		this.type = type;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public String getLink() {
		return link;
	}

	public Type getType() {
		return type;
	}
	
	

}
