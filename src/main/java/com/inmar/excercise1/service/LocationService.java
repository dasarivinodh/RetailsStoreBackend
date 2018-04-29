package com.inmar.excercise1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.inmar.excercise1.repositary.LocationRepositary;
import com.inmar.excercise1.model.Location;

@Service
public class LocationService {

	@Autowired
	private LocationRepositary locationRepositary;

	public List<Location> getAllLocation() {

		return (List<Location>) (locationRepositary.findAll());

	}

	public Optional<Location> getLocationById(int locationId) {

		return locationRepositary.findById((long) locationId);

	}

	public Location createLocation(Location location) {

		return locationRepositary.save(location);

	}

	public ResponseEntity<Location> updateLocation(Location location) {
		if (!locationRepositary.findById(location.getId()).isPresent()) {
			return ResponseEntity.notFound().build();

		}
		Location l = locationRepositary.save(location);
		return ResponseEntity.accepted().body(l);
	}

	public ResponseEntity<Location> deleteLocation(Long locationId) {

		
		if (locationRepositary.findById(locationId).isPresent()) {
			locationRepositary.deleteById((long) locationId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
