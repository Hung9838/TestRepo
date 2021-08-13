package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.DepartmentDao;
import com.test.entity.Department;
import com.test.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentDao departmentDao;

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public Department create(Department department) {
		return departmentDao.save(department);
	}

	@Override
	public void remove(String id) {
		departmentDao.deleteById(id);
	}

	@Override
	public Optional<Department> findById(String id) {
		return departmentDao.findById(id);
	}

	@Override
	public List<Department> findByName(String name) {
		return departmentDao.findByName(name);
	}

	@Override
	public Department update(Department department) {
		return departmentDao.save(department);
	}
	
}
