package com.cgi.spring_whole_demo;

public class Location {
	private String LocationId;
	private String City;
	private String Country;
	public String getLocationId() {
		return LocationId;
	}
	public void setLocationId(String locationId) {
		LocationId = locationId;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	@Override
	public String toString() {
		return "Location [LocationId=" + LocationId + ", City=" + City + ", Country=" + Country + "]";
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}

}
