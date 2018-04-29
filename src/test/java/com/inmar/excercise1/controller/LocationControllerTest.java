package com.inmar.excercise1.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inmar.excercise1.model.Location;
import com.inmar.excercise1.service.LocationService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LocationController.class, secure = false)
public class LocationControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LocationService locationService;

	@Test
	public void getLocationById() throws Exception {

		Location l = new Location(1l, "Hyderabad", "Capital City");

		Optional<Location> ol = Optional.of(l);

		String URI = "/location/1";

		Mockito.when(locationService.getLocationById(Mockito.anyInt()))
				.thenReturn(ol);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(
				"application/json");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = this.mapToJson(l);

		String actual = result.getResponse().getContentAsString();
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	public void createLocation() throws Exception {

		Location l = new Location(1l, "Hyderabad", "Capital City");

		String URI = "/location";

		String jsonInput = mapToJson(l);
		Mockito.when(
				locationService.createLocation(Mockito.any(Location.class)))
				.thenReturn(l);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept("application/json")
				.content(jsonInput)
				.contentType(
						org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String actual = result.getResponse().getContentAsString();

		assertThat(actual).isEqualTo(jsonInput);
	}
     
	@Test
	public void updateLocation() throws Exception {

		Location l = new Location(1l, "Hyderabad", "Capital City");

		String URI = "/location";

		
		
		String jsonInput = mapToJson(l);
		
		ResponseEntity<Location> re=ResponseEntity.accepted().body(l);
		Mockito.when(
				locationService.updateLocation(Mockito.any(Location.class)))
				.thenReturn(re);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put(URI)
				.accept("application/json")
				.content(jsonInput)
				.contentType(
						org.springframework.http.MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String actual = result.getResponse().getContentAsString();


		assertThat(actual).isEqualTo(jsonInput);
	}

	@Test
	public void deleteLocation() throws Exception {


		String URI = "/location/1";		
		
		ResponseEntity<Location> re=ResponseEntity.ok().build();
		Mockito.when(
				locationService.deleteLocation(Mockito.anyLong()))
				.thenReturn(re);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete(URI)
				.accept("application/json");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		int actual = result.getResponse().getStatus();

		System.out.println(re.getStatusCodeValue() + "<< Expected  Actual>>  " + actual);

		assertThat(actual).isEqualTo(re.getStatusCodeValue());
	}
	private String mapToJson(Object object) throws JsonProcessingException {

		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(object);
	}
}
