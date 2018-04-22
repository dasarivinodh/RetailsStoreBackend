package com.inmar.excercise1.repositary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.inmar.excercise1.model.Category;
import com.inmar.excercise1.model.Department;
import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.model.SKUModel;

@Repository
public interface SKURepositary extends JpaRepository<SKUModel, Long>{

//	List<Department> findByLocationId(Long locationId);
//	
//	List<Category> findByDepartmentId(Long departmentId);
//	List<Category> findByDepartmentIdAndId(Long departmentId,Long id);
//	@Transactional
//    Long deleteByDepartmentIdAndId(Long departmentId,Long id);
	
	List <SKUModel>  findByCategoryAndLocationAndDepartmentAndSubcategory(String category,String location,String department,String subcategory);
	List <SKUModel>  findByLocationAndDepartment(String location,String department);
	List <SKUModel>  findByLocation(String location);
}
