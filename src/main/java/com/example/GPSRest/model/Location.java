package com.example.GPSRest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column
	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message = "deviceid must be a number")
	private String deviceid;
	@Column
	@Min(value = 0, message = "Invalid latitude(below zero)")
	private int latitude;
	@Column
	@Min(value = 0, message = "Invalid longitude(below zero)")
	private int longitude;

	public Location() {

	}
	
	public Location(@Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message = "deviceid must be a number") String deviceid,
			@Min(value = 0, message = "Invalid latitude(below zero)") int latitude,
			@Min(value = 0, message = "Invalid longitude(below zero)") int longitude) {
		this.deviceid = deviceid;
		this.latitude = latitude;
		this.longitude = longitude;
	}



	public String getDeviceId() {
		return deviceid;
	}

	public void setDeviceId(String deviceId) {
		this.deviceid = deviceId;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}


}
