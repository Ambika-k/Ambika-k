package com.zensar.ide.endpoints;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "course-details")
public class CustomEndpoint {
	private Map<Integer, String> courseDetails = new HashMap<>();

	@PostConstruct
	public void init() {
		courseDetails.put(1, "Java");
		courseDetails.put(2, "DotNet");
	}

	@ReadOperation
	public Map<Integer, String> getAllCourses() {
		return courseDetails;

	}

	@ReadOperation
	public String getCourseById(@Selector int id) {
		return courseDetails.get(id);

	}

	@WriteOperation
	public void addCourse(@Selector int id, @Selector String course) {
		courseDetails.put(id, course);
	}

	@DeleteOperation
	public void deleteCourse(@Selector int id) {
		courseDetails.remove(id);
	}
}
