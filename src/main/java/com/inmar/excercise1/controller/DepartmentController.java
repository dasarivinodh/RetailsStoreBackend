package com.inmar.excercise1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmar.excercise1.model.Department;
import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.service.DepartmentService;
import com.inmar.excercise1.service.LocationService;

@RestController
@RequestMapping("/location/{locationid}/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService; 
	@Autowired
	LocationService locationService;
	
	@GetMapping()
	public List<Department> getAllDepartment(@PathVariable Long locationid)
	{
		return departmentService.getAllDepartment(locationid);
	}
	@GetMapping("/{departmentid}")
	public List<Department> getDepartmentById(@PathVariable Long departmentid,@PathVariable Long locationid)
	{
		return departmentService.getDepartmentById(departmentid,locationid);
	}
	@PostMapping()
	public Department createDepartment(@RequestBody Department department,@PathVariable long locationid){
		
		return departmentService.createDepartment(department,locationid);
	}
	@PutMapping()
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department,@PathVariable long locationid){
		
		return departmentService.updateDepartment(department,locationid);
	}
	
	@DeleteMapping("/{departmentid}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable Long departmentid,@PathVariable Long locationid){
		
		return departmentService.deleteDepartment(departmentid,locationid);
	}
	

}
