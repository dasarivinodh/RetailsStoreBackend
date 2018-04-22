package com.inmar.excercise1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.repositary.LocationRepositary;
import com.inmar.excercise1.service.LocationService;

@CrossOrigin(origins = "http://localhost:8080/", maxAge = 3600)
@RestController
@RequestMapping("/location")
public class LocationController {
	
	
	@Autowired
	LocationService locationService;
	
//	 @CrossOrigin(origins = "http://localhost/Excercise1/location")
	@GetMapping()
	public List<Location> getAllLocations(){
		
		return locationService.getAllLocation();
	}
	
	@GetMapping("/{locationid}")
	public Optional<Location> getLocationById(@PathVariable(value="locationid") int locationid){
		
		return locationService.getLocationById(locationid);
	}
//	 @CrossOrigin(origins = "http://localhost/Excercise1/location")
	@PostMapping()
	public Location createLocation(@RequestBody Location location){
		
		return locationService.createLocation(location);
	}
	@PutMapping()
	public ResponseEntity<Location> updateLocation(@RequestBody Location location){
		
		return locationService.updateLocation(location);
	}
	@DeleteMapping("/{locationId}")
	public String deleteLocation(@PathVariable(value="locationId") Long locationId){
		
		return locationService.deleteLocation(locationId);
	}
	

}
