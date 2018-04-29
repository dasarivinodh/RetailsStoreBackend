package com.inmar.excercise1.repositary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmar.excercise1.model.Department;

@Repository
public interface DepartmentRepositary extends JpaRepository<Department, Long>{

	List<Department> findByLocationId(Long locationId);
	
	List<Department> findByLocationIdAndId(Long locationId,Long id);

	@Transactional
    Long deleteByLocationIdAndId(Long locationId,Long id);
}
