package com.inmar.excercise1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inmar.excercise1.model.Category;
import com.inmar.excercise1.model.Department;
import com.inmar.excercise1.model.SubCategory;
import com.inmar.excercise1.repositary.CategoryRepositary;
import com.inmar.excercise1.repositary.DepartmentRepositary;
import com.inmar.excercise1.repositary.LocationRepositary;
import com.inmar.excercise1.repositary.SubCategoryRepositary;
@Service
public class SubCategoryService {

	@Autowired
	LocationRepositary locationRepositary;
	@Autowired
	DepartmentRepositary departmentRepositary;
	@Autowired
	CategoryRepositary categoryRepositary;
	@Autowired
	SubCategoryRepositary subCategoryRepositary;

	@Autowired
	Category category;

	public List<SubCategory> getAllSubCategory(Long locationid,
			Long departmentid, Long categoryid) {
		if (departmentRepositary
				.findByLocationIdAndId(locationid, departmentid).isEmpty()
				|| categoryRepositary.findByDepartmentIdAndId(departmentid,
						categoryid).isEmpty()) {
			return null;
		}
		return subCategoryRepositary.findByCategoryId(categoryid);
	}

	public ResponseEntity<SubCategory> getSubCategoryById(Long locationid,
			 Long departmentid, Long categoryid,Long subcategoryid) {
		if (departmentRepositary
				.findByLocationIdAndId(locationid, departmentid).isEmpty()
				|| categoryRepositary.findByDepartmentIdAndId(departmentid,
						categoryid).isEmpty()||subCategoryRepositary.findByCategoryIdAndId(categoryid, subcategoryid).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		SubCategory s = subCategoryRepositary.findById(subcategoryid).get();
		return ResponseEntity.ok().body(s);
	}

	public ResponseEntity<SubCategory> createSubCategory(
			SubCategory subCategory, Long locationid, Long departmentid,
			Long categoryid) {
		if (departmentRepositary
				.findByLocationIdAndId(locationid, departmentid).isEmpty()
				|| categoryRepositary.findByDepartmentIdAndId(departmentid,
						categoryid).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		// get Location Information if already exist
		category = categoryRepositary.getOne(categoryid);
		if (null != category) {
			// Adding Values to Department
			subCategory.setCategory(category);

			SubCategory sc = subCategoryRepositary.save(subCategory);
			return ResponseEntity.accepted().body(sc);
		}
		return null;
	}

	public ResponseEntity<SubCategory> updateSubCategory(
			SubCategory subCategory, Long locationid, Long departmentid,
			Long categoryid) {
		if (departmentRepositary
				.findByLocationIdAndId(locationid, departmentid).isEmpty()
				|| categoryRepositary.findByDepartmentIdAndId(departmentid,
						categoryid).isEmpty()|| subCategoryRepositary.findByCategoryIdAndId(categoryid, subCategory.getId()).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		// get Location Information if already exist
		category = categoryRepositary.getOne(categoryid);
		if (null != category) {
			// Adding Values to Department
			subCategory.setCategory(category);

			SubCategory sc = subCategoryRepositary.save(subCategory);
			return ResponseEntity.accepted().body(sc);
		}
		return null;
	}

	public ResponseEntity<SubCategory> deleteSubCategory(Long categoryId, Long subCategoryId) {
		Long result = subCategoryRepositary.deleteByCategoryIdAndId(categoryId,
				subCategoryId);
		if (result > 0)
			return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}

}
