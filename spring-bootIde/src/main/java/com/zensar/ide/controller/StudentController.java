package com.zensar.ide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.ide.entity.Student;
import com.zensar.ide.service.StudentService;

@RestController
//@RequestMapping("/studentapp")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {
		return studentService.getStudent(studentId);

	}
	
	@GetMapping("/")
	public String Home() {
		return "Home Page";
	}
	@GetMapping("/user")
	public String User() {
		return "User Page";
		
	}
	@GetMapping("/admin")
	public String Admin() {
		return "Admin Page";
		
	}

	// public Student insertStudent(@ResponseBody)

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getStudents();
		

	}

	/*
	 * @GetMapping("/students") public List<Student> getAllStudents() { return
	 * studentService.getStudents(); }
	 */
}
