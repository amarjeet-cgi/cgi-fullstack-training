package org.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	private int studentId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "natinality")
	private String natinality;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "entering_date")
	private Date entering_date;
	
	
	public Student(String name, String natinality, String code, Date entering_date) {
		super();
		this.name = name;
		this.natinality = natinality;
		this.code = code;
		this.entering_date = entering_date;
	}
	
	public Student(int studentId, String name, String natinality, String code, Date entering_date) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.natinality = natinality;
		this.code = code;
		this.entering_date = entering_date;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNatinality() {
		return natinality;
	}

	public void setNatinality(String natinality) {
		this.natinality = natinality;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getEntering_date() {
		return entering_date;
	}

	public void setEntering_date(Date entering_date) {
		this.entering_date = entering_date;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", Name=" + name + ", natinality=" + natinality + ", code="
				+ code + ",Date= "+entering_date +" ]";
	}
	
	

}
