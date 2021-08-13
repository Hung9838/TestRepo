package com.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.User;

public interface UserDao extends JpaRepository<User, String>{
	List<User> findByEmail(String email);
}
