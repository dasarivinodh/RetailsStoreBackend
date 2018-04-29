package com.inmar.excercise1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inmar.excercise1.model.Department;
import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.repositary.DepartmentRepositary;
import com.inmar.excercise1.repositary.LocationRepositary;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepositary departmentRepositary;

	@Autowired
	LocationRepositary locationRepositary;
	
    @Autowired
	Location location;

	public List<Department> getAllDepartment(Long locationid) {

		return departmentRepositary.findByLocationId(locationid);
	}

	public List<Department> getDepartmentById(Long departmentId, Long locationid) {
		return departmentRepositary.findByLocationIdAndId(locationid,
				departmentId);
	}

	public Department createDepartment(Department department, long locationid) {

		// get Location Information if already exist
		location = locationRepositary.getOne(locationid);
		if (null != location) {
			// Adding Values to Department
			department.setLocation(location);

			return departmentRepositary.save(department);
		}
		return null;
	}

	public ResponseEntity<Department> updateDepartment(Department department,
			long locationid) {

		if (!departmentRepositary.findById(locationid).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		
		// get Location Information if already exist
		location = locationRepositary.getOne(locationid);
		if (null != location) {
			// Adding Values to Department
			department.setLocation(location);
			Department d = departmentRepositary.save(department);
			return ResponseEntity.accepted().body(d);
		}
		return ResponseEntity.accepted().build();
	}

	public ResponseEntity<Department> deleteDepartment(Long departmentid, Long locationid) {
		Long result = departmentRepositary.deleteByLocationIdAndId(locationid,
				departmentid);

		if (result > 0)
			return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}

}
