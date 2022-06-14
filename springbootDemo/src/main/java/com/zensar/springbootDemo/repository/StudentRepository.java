package com.zensar.springbootDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.springbootDemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	
}
