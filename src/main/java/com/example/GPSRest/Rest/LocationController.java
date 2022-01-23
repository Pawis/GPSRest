package com.example.GPSRest.Rest;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.GPSRest.Service.LocationService;
import com.example.GPSRest.model.Location;

@Controller
public class LocationController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private LocationService locationService;

	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	@PostMapping("/post")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void createLocation(@RequestBody @Valid Location locationBody) {
		
		logger.info("Start " + Thread.currentThread().getName());
		locationService.saveLocationToDatabase(locationBody);
		logger.info("End " + Thread.currentThread().getName());
		
	
	}
	
}
