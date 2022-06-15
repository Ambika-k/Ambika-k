package com.zensar.springbootDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.springbootDemo.dto.StudentDto;
import com.zensar.springbootDemo.entity.Student;
import com.zensar.springbootDemo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	public StudentServiceImpl() {

	}

	@Override
	public StudentDto getStudent(int studentId) {
		Student getStudent = studentRepository.findById(studentId).get();
		//StudentDto dto = mapToDto(getStudent);
		return modelMapper.map(getStudent,StudentDto.class);
	}

	@Override
	public List<StudentDto> getStudents() {
		List<Student> listOfStudents = studentRepository.findAll();
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		for (Student student : listOfStudents) {
			listOfStudentDto.add(modelMapper.map(student,StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		//Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto,Student.class);
		Student insertedStudent = studentRepository.save(student);
		//StudentDto maptoDto = mapToDto(insertedStudent);
		//return maptoDto;
		return modelMapper.map(insertedStudent,StudentDto.class);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto studentDto) {
		//Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto,Student.class);
		Student updatedStudent = studentRepository.save(student);
		//StudentDto dto = mapToDto(updatedStudent);
		//return dto;
		return modelMapper.map(updatedStudent,StudentDto.class);
	}

	/*
	 * public Student mapToEntity(StudentDto studentDto) { Student student = new
	 * Student(); student.setStudentId(studentDto.getStudentId());
	 * student.setStudentName(studentDto.getStudentName());
	 * student.setStudentAge(studentDto.getStudentAge()); return student; }
	 * 
	 * public StudentDto mapToDto(Student student) { StudentDto dto = new
	 * StudentDto(); dto.setStudentId(student.getStudentId());
	 * dto.setStudentName(student.getStudentName());
	 * dto.setStudentAge(student.getStudentAge()); return dto;
	 * 
	 * }
	 */
}
