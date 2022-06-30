package com.zensar.ide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.ide.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
