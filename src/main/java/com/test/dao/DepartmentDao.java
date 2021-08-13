package com.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Department;

public interface DepartmentDao extends JpaRepository<Department, String>{
	List<Department> findByName(String name);
	
	
}
