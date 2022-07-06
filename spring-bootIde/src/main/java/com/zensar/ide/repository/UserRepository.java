package com.zensar.ide.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.ide.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	User findByUserName(String userName);

}
