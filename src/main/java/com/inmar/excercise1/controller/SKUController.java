package com.inmar.excercise1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.model.SKUModel;
import com.inmar.excercise1.service.SKUService;

@RestController
@RequestMapping("/findskumetadata/{locationid}/{departmentid}/{categoryid}/{subcategoryid}")
public class SKUController {

	@Autowired
	SKUModel skuModel;

	@Autowired
	SKUService skuService;

	@GetMapping()
	public List<Location> searchSKU(
	@PathVariable Long locationid, @PathVariable Long departmentid,
			@PathVariable Long categoryid,@PathVariable Long subcategoryid) {

		

		return skuService.getAllSKUModel(locationid,departmentid,categoryid, subcategoryid);
	}
}
