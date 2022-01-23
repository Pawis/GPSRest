package com.example.GPSRest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.GPSRest.Rest.LocationController;
import com.example.GPSRest.Service.LocationService;
import com.example.GPSRest.model.Location;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ThreadPoolTaskExecutor executor;
	
	@InjectMocks
	private LocationController locationController;
	
	@Mock 
	private LocationService locationService;
	
	@Test
	void testcreateLocation()  {
		
		Location location = new Location("1",123,123);
		
		when(locationService.saveLocationToDatabase(any(Location.class))).thenReturn(location);
		assertTrue(locationService.saveLocationToDatabase(location).equals(location));
	}
	@Test
	void testcreateLocationResponse() throws Exception{
		
		
		JSONObject json = new JSONObject("{'deviceid':'1', 'latitude':30, 'longitude':20}");
		String jsons = json.toString();
		 mockMvc.perform(post("/post")
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(jsons))
         .andExpect(status().isAccepted());
		 
		 executor.getThreadPoolExecutor().awaitTermination(1, TimeUnit.SECONDS);
	}
}
