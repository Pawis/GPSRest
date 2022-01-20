package com.example.GPSRest.Rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.GPSRest.Repo.LocationRepo;
import com.example.GPSRest.model.Location;


@RestController
public class LocationController {
	
	private static final Logger logger = LogManager.getLogger(LocationController.class);
	
	@Autowired
	private LocationRepo locationRepo;

	@PostMapping("/post")
	public Location createLocation(@RequestBody Location locationBody) {
		
		return locationRepo.save(locationBody);
	}
	
}
