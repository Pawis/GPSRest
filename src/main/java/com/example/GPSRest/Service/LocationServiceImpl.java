package com.example.GPSRest.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.GPSRest.Repo.LocationRepo;
import com.example.GPSRest.model.Location;


@Service
public class LocationServiceImpl implements LocationService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private LocationRepo locatiobRepo;
	
	public LocationServiceImpl(LocationRepo locatiobRepo) {
		this.locatiobRepo=locatiobRepo;
	}
	
	public Location saveLocationToDatabase(Location location) {
		
		logger.info("StartService " + Thread.currentThread().getName());
		Location loc = locatiobRepo.save(location);
		logger.info("EndService " + Thread.currentThread().getName());
		return loc;
	}
	
}
