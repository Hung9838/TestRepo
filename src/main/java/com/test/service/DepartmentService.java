package com.test.service;

import java.util.List;
import java.util.Optional;

import com.test.entity.Department;

public interface DepartmentService {
		// Lay tat ca
		List<Department> findAll();
		// Them
		Department create(Department department);
		// Sua
		Department update(Department department);
		// Xoa
		void remove(String id);
		// Tim kiem theo id
		Optional<Department> findById(String id);
		// Tim kiem theo ten
		List<Department> findByName(String name); 
	
}
