package com.cgi.spring_whole_demo;

public class Employee {
	private String EmployeeId;
	private String FirstName;
	private String LastName;
	private String Email;
	private Department department;
	public void initEmployee()
	{
		System.out.println("Employee init called");
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getFirstName() {
		return FirstName;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email="
				+ Email + ", department=" + department + "]";
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void customDestroyMethod()
	{
		System.out.println("bean detroyed");
	}
	

}
