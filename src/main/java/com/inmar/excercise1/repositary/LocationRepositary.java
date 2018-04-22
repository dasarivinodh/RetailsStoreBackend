package com.inmar.excercise1.repositary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.inmar.excercise1.model.Location;

@Repository
public interface LocationRepositary extends JpaRepository<Location, Long>{

	
//	
//	@Query("SELECT l FROM Location l LEFT JOIN l.department d WHERE d.id LIKE %:deptId%")
//	List<Location> findBySearchItem(@Param("deptid") Long departmentId);
	
}
