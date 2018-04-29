package com.inmar.excercise1.repositary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmar.excercise1.model.Category;

@Repository
public interface CategoryRepositary extends JpaRepository<Category, Long>{

	
	List<Category> findByDepartmentId(Long departmentId);
	List<Category> findByDepartmentIdAndId(Long departmentId,Long id);
	@Transactional
    Long deleteByDepartmentIdAndId(Long departmentId,Long id);
}
