package com.cgi.spring_whole_demo;

public class Department {
	
	private String DepartmentId;
	private String DepartmentName;
	private Location location;
	
	public Location getLocation() {
		return location;
	}
	@Override
	public String toString() {
		return "Department [DepartmentId=" + DepartmentId + ", DepartmentName=" + DepartmentName + ", location="
				+ location + "]";
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(String departmentId) {
		DepartmentId = departmentId;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}	
	

}
