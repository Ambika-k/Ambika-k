package com.zensar.springbootDemo.service;

import java.util.List;

import com.zensar.springbootDemo.dto.StudentDto;
import com.zensar.springbootDemo.entity.Student;

public interface StudentService {
	public StudentDto getStudent(int studentId);

	public List<StudentDto> getStudents();

	public StudentDto insertStudent(StudentDto studentdto);

	public void deleteStudent(int studentId);

	public StudentDto updateStudent(int studentId, StudentDto studentDto);
}
