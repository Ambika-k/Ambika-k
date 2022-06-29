package com.zensar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.entity.Student;
import com.zensar.repository.StudentRepositoryImpl;

public class SpringJdbcMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Application context loaded");
		StudentRepositoryImpl studentRepositoryImpl = context.getBean("studentRepository", StudentRepositoryImpl.class);

		// CREATE STUDENT 
		Student student = new Student();
		student.setStudentId(104);
		student.setStudentName("rashi");
		student.setStudentAge(25);
		student.setAddress("Nellore");

		// StudentRepository studentRepository = new StudentRepositoryImpl();
		// studentRepository.insert(student);

		// INSERT STUDENT
		studentRepositoryImpl.insert(student);
		// READ STUDENT
		studentRepositoryImpl.findById(101);
		studentRepositoryImpl.findByName("rashi");
		// DELETE STUDENT
		studentRepositoryImpl.deleteStudent(102);
		// UPDATE STUDENT
		studentRepositoryImpl.updateStudent(103,"Kavya");

	}

}
