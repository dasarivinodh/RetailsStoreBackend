package com.inmar.excercise1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inmar.excercise1.model.Category;
import com.inmar.excercise1.model.Department;
import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.model.SKUModel;
import com.inmar.excercise1.repositary.CategoryRepositary;
import com.inmar.excercise1.repositary.DepartmentRepositary;
import com.inmar.excercise1.repositary.LocationRepositary;
import com.inmar.excercise1.repositary.SKURepositary;
import com.inmar.excercise1.repositary.SubCategoryRepositary;

@Service
public class SKUService {

	@Autowired
	LocationRepositary locationRepositary;

	@Autowired
	SKUModel skuModel;



	



	public List<Location> getAllSKUModel(Long locationid, Long departmentid,
			Long categoryid, Long subcategoryid) {
//		List<Location> l=locationRepositary.findBySearchItem(departmentid);
		return null;
	}


}
