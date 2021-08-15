package com.test.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Department;
import com.test.service.impl.DepartmentServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")

public class DepartmentRestController {
	
	@Autowired
	DepartmentServiceImpl departmentService;
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getAllDeppartment(Model model) {
		List<Department> listDepartment = departmentService.findAll();
		if (listDepartment.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listDepartment);
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getOneDepartment(@PathVariable("id") String id) {
		if (departmentService.findById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(departmentService.findById(id).get());
	}
	
	@PostMapping("/department")
	public ResponseEntity<Department> postDepartment(@RequestBody Department department) {
		if (!departmentService.findById(department.getId()).isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		departmentService.create(department);
		return ResponseEntity.ok(department);
	}
	
	@PutMapping("/department")
	public ResponseEntity<Department> putDepartment( 
			@RequestBody Department department) {
		if (departmentService.findById(department.getId()).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		departmentService.update(department);
		return ResponseEntity.ok(department);
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable("id") String id) {
		if (departmentService.findById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		try {
			departmentService.remove(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/departmentProperty/{name}")
	public ResponseEntity<List<Department>> getNameDepartment(@PathVariable("name") String name) {

		return ResponseEntity.ok(departmentService.findByName(name));
	}

}
