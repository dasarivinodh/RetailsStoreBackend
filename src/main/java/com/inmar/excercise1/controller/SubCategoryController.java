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

import com.inmar.excercise1.model.SubCategory;
import com.inmar.excercise1.service.SubCategoryService;


@RestController
@RequestMapping("/location/{locationid}/department/{departmentid}/category/{categoryid}/subcategory")
public class SubCategoryController {
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@GetMapping()
	public List<SubCategory> getAllSubCategory(@PathVariable Long locationid,@PathVariable Long departmentid,@PathVariable Long categoryid){
		
		return subCategoryService.getAllSubCategory(locationid,departmentid,categoryid);
	}
	
	@GetMapping("/{subcategoryid}")
	public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Long locationid,@PathVariable Long departmentid,@PathVariable Long categoryid,@PathVariable Long subcategoryid){
		
		return subCategoryService.getSubCategoryById(locationid,departmentid,categoryid,subcategoryid);
	}
	
	@PostMapping()
	public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategory subCategory,@PathVariable Long locationid,@PathVariable Long departmentid,@PathVariable Long categoryid){
		
		return subCategoryService.createSubCategory(subCategory,locationid,departmentid,categoryid);
	}
	@PutMapping()
	public ResponseEntity<SubCategory> updateSubCategory(@RequestBody SubCategory subCategory,@PathVariable Long locationid,@PathVariable Long departmentid,@PathVariable Long categoryid){
		
		return subCategoryService.updateSubCategory(subCategory,locationid,departmentid,categoryid);
	}
	@DeleteMapping("/{subcategoryid}")
	public String deleteSubCategory(@PathVariable Long categoryid,@PathVariable Long subcategoryid){
		
		return subCategoryService.deleteSubCategory(categoryid,subcategoryid);
	}
	

}
