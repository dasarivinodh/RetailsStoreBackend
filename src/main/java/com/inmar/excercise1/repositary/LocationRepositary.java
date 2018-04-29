package com.inmar.excercise1.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmar.excercise1.model.Location;

@Repository
public interface LocationRepositary extends JpaRepository<Location, Long>{
	
}
