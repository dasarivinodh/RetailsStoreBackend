package com.inmar.excercise1.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.repositary.LocationRepositary;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceTest {

	@Autowired
	LocationService locationService;

	@MockBean
	LocationRepositary locationRepositary;

	@Test
	public void getLocationbyId() {

		Location l = new Location(1l, "Hyderabad", "Capital City");
		Optional<Location> ol = Optional.of(l);
		Mockito.when(locationRepositary.findById(1l)).thenReturn(ol);
		assertThat(locationService.getLocationById(1)).isEqualTo(ol);
	}

	@Test
	public void createLocation() {

		Location l = new Location(1l, "Hyderabad", "Capital City");

		Mockito.when(locationRepositary.save(l)).thenReturn(l);

		assertThat(locationService.createLocation(l)).isEqualTo(l);
	}

	@Test
	public void updateLocation() {
		Location l = new Location(1l, "Hyderabad", "Capital City");
		Optional<Location> ol = Optional.of(l);
		Mockito.when(locationRepositary.save(l)).thenReturn(l);
		Mockito.when(locationRepositary.findById(1l)).thenReturn(ol);
		assertThat(locationService.updateLocation(l).getBody()).isEqualTo(l);
	}

	@Test
	public void deleteLocation() {
		Location l = new Location(1l, "Hyderabad", "Capital City");
		Optional<Location> ol = Optional.of(l);
		Mockito.when(locationRepositary.findById(1l)).thenReturn(ol);
		assertThat(locationService.deleteLocation(1l).getStatusCode())
				.isEqualTo(HttpStatus.OK);
	}

}
