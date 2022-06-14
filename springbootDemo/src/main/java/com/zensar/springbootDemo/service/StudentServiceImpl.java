package com.zensar.springbootDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.springbootDemo.entity.Student;
import com.zensar.springbootDemo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public StudentServiceImpl() {

	}

	@Override
	public Student getStudent(int studentId) {

		return studentRepository.findById(studentId).get();
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void insertStudent(Student student) {
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public void updateStudent(int studentId, Student student) {
		studentRepository.save(student);

	}

}
