package com.zensar.ide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.ide.entity.Student;
import com.zensar.ide.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(int studentId) {
		
		return studentRepository.findById(studentId).get();
	}

	@Override
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student insertStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
		
	}

	@Override
	public Student updateStudent(int studentId, Student student) {
		return studentRepository.save(student);
	}
	
}
