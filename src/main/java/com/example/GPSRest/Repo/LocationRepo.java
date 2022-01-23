package com.example.GPSRest.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import com.example.GPSRest.model.Location;

public interface LocationRepo extends CrudRepository<Location,Integer> {
	
	
	@Override
	@Async("asyncExecutor")
	public <T extends Location> T save(T location);
	
}
