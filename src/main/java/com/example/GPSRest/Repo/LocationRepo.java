package com.example.GPSRest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GPSRest.model.Location;

public interface LocationRepo extends JpaRepository<Location,Integer>{
	
}
