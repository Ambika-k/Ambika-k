package com.zensar.springbootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springbootDemo.dto.StudentDto;
import com.zensar.springbootDemo.entity.Student;
import com.zensar.springbootDemo.service.StudentService;

@RestController
@RequestMapping(value = "/student-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController() {

	}

	// @RequestMapping("/students/{studentId}")
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId),HttpStatus.OK);
		//return studentService.getStudent(studentId);
	}

	// @RequestMapping(value = { "/students", "/listOfStudents" }, method =
	// RequestMethod.GET)
	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDto>> getStudents() {
		return new ResponseEntity<List<StudentDto>>(studentService.getStudents(),HttpStatus.OK);
		//return studentService.getStudents();
	}

	// @RequestMapping(value = "/students", method = RequestMethod.POST)
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.insertStudent(studentDto),HttpStatus.CREATED);
		//return studentService.insertStudent(studentDto);
	}

	// @RequestMapping(value = "/students/{studentId}", method =
	// RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
	}

	// @RequestMapping(value="/students/{studentId}", method = RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId") int studentId, @RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.updateStudent(studentId, studentDto),HttpStatus.OK);
		//return studentService.updateStudent(studentId, studentDto);
	}

}
