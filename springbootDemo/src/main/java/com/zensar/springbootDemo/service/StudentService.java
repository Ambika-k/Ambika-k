package com.zensar.springbootDemo.service;

import java.util.List;

import com.zensar.springbootDemo.entity.Student;

public interface StudentService {
	public Student getStudent(int studentId);

	public List<Student> getStudents();

	public void insertStudent(Student student);

	public void deleteStudent(int studentId);

	public void updateStudent(int studentId, Student student);
}
