package org.example.demo.dao;

import java.util.List;

import org.example.demo.model.Student;

public interface StudentDao {

	public void addStudent(Student student);
	public List<Student> displayAllStudent();
	public Student findStudentById(int id);
	public Student findStudentByName(String name);
	public Student findStudentByDate(String date);
	public Student updateStudentById(int id, Student student);
	public Student updateStudentByName(String name, Student student);
	public void deleteById(int id);
	public void deleteAll();
}
