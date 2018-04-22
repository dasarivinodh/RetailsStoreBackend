package com.inmar.excercise1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inmar.excercise1.model.Category;
import com.inmar.excercise1.model.Department;
import com.inmar.excercise1.repositary.CategoryRepositary;
import com.inmar.excercise1.repositary.DepartmentRepositary;
import com.inmar.excercise1.repositary.LocationRepositary;

@Service
public class CategoryService {

	@Autowired
	LocationRepositary locationRepositary;
	@Autowired
	DepartmentRepositary departmentRepositary;
	@Autowired
	CategoryRepositary categoryRepositary;
	@Autowired
	Department department;

	public List<Category> getAllCategory(Long locationid, Long departmentid) {
		if (departmentRepositary
				.findByLocationIdAndId(locationid, departmentid).isEmpty()) {
			return null;
		}
		return categoryRepositary.findByDepartmentId(departmentid);

	}

	public Category getCategoryById(Long locationid, Long departmentid,
			Long categoryid) {

		if (departmentRepositary
				.findByLocationIdAndId(locationid, departmentid).isEmpty()) {
			return null;
		}
		return categoryRepositary.findById(categoryid).get();
	}

	public ResponseEntity<Category> createCategory(Category category,
			Long locationid, Long departmentid) {

		if (departmentRepositary.findByLocationIdAndId(locationid,
				departmentid).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		// get Location Information if already exist
		department = departmentRepositary.getOne(departmentid);
		if (null != department) {
			// Adding Values to Department
			category.setDepartment(department);

			Category c = categoryRepositary.save(category);
			return ResponseEntity.accepted().body(c);
		}
		return null;

	}

	public ResponseEntity<Category> updateCategory(Category category,Long locationid, Long departmentid) {

		if (departmentRepositary.findByLocationIdAndId(locationid,
				departmentid).isEmpty()
				|| !categoryRepositary.findById(category.getId()).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// get Location Information if already exist
		department = departmentRepositary.getOne(departmentid);
		if (null != department) {
			// Adding Values to Department
			category.setDepartment(department);

			Category c = categoryRepositary.save(category);
			return ResponseEntity.accepted().body(c);
		}
		return null;

	}

	public String deleteCategory(Long departmentid,Long categoryId) {

		
		//implementation for department id and location id check
		Long result= categoryRepositary.deleteByDepartmentIdAndId(departmentid, categoryId);
        
		if(result>0)
			return "Deleted Success Fully";
		return "Unable to Find Entity";
		
	}

}
