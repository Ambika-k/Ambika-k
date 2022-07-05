package com.zensar.ide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.ide.entity.Student;
import com.zensar.ide.model.AuthenticationRequest;
import com.zensar.ide.model.AuthenticationResponse;
import com.zensar.ide.service.MyUserDetailsService;
import com.zensar.ide.service.StudentService;
import com.zensar.ide.util.JwtUtil;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {
		return studentService.getStudent(studentId);

	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken (authenticationRequest.getUserName(),authenticationRequest.getPassword()));
		}
		catch( BadCredentialsException e) {
			throw new Exception("Incorrect Username or password",e);
		}
		final UserDetails userDetails= myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	
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
