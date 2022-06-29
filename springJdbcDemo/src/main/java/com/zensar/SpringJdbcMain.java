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

		Student student = new Student();
		student.setStudentId(104);
		student.setStudentName("rashi");
		student.setStudentAge(25);
		student.setAddress("Nellore");

		// StudentRepository studentRepository = new StudentRepositoryImpl();
		// studentRepository.insert(student);

		studentRepositoryImpl.insert(student);
		studentRepositoryImpl.findById(101);
		studentRepositoryImpl.findByName("rashi");
		studentRepositoryImpl.deleteStudent(102);
		studentRepositoryImpl.updateStudent(103,"Kavya");

	}

}
