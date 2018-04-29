package com.inmar.excercise1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

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

import com.inmar.excercise1.model.Category;
import com.inmar.excercise1.service.CategoryService;


@RestController
@RequestMapping("/location/{locationid}/department/{departmentid}/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping()
	public List<Category> getAllCategory(@PathVariable Long locationid,@PathVariable Long departmentid ){
		
		return categoryService.getAllCategory(locationid,departmentid);
	}
	
	@GetMapping("/{categoryid}")
	public Category getCategoryById(@PathVariable Long locationid,@PathVariable Long departmentid,@PathVariable Long categoryid){
		
		return categoryService.getCategoryById(locationid,departmentid,categoryid);
	}
	
	@PostMapping()
	public ResponseEntity<Category> createCategory(@RequestBody Category category,@PathVariable Long locationid,@PathVariable Long departmentid){
		
		return categoryService.createCategory(category, locationid, departmentid);
	}
	@PutMapping()
	public ResponseEntity<Category> updateCategory(@RequestBody Category category,@PathVariable Long locationid,@PathVariable Long departmentid){
		
		return categoryService.updateCategory(category, locationid, departmentid);
	
	}
	@DeleteMapping("/{categoryid}")
	public ResponseEntity<Category> deleteCategory(@PathVariable Long departmentid,@PathVariable Long categoryid){
		
		return categoryService.deleteCategory(departmentid,categoryid);
	}
	

}
