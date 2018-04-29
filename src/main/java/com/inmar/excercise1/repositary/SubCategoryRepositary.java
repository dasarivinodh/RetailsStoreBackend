package com.inmar.excercise1.repositary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmar.excercise1.model.SubCategory;

@Repository
public interface SubCategoryRepositary extends JpaRepository<SubCategory, Long> {

	List<SubCategory> findByCategoryId(Long categoryId);

	List<SubCategory> findByCategoryIdAndId(Long categoryId, Long id);

	@Transactional
	Long deleteByCategoryIdAndId(Long categoryId, Long id);
}
