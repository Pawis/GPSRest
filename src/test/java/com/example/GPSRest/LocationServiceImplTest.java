package com.example.GPSRest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.GPSRest.Repo.LocationRepo;
import com.example.GPSRest.Service.LocationServiceImpl;
import com.example.GPSRest.model.Location;

@SpringBootTest
class LocationServiceImplTest {

	@InjectMocks
	private LocationServiceImpl locationService;
	
	@Mock
	private LocationRepo locationRepo;
	
	@Test
	void testSaveLocationToDatabase() {
		
		Location location = new Location("1",123,123);
		
		when(locationRepo.save(any(Location.class))).thenReturn(location);
		
		assertTrue(locationService.saveLocationToDatabase(location).equals(location));
		
	}

}
