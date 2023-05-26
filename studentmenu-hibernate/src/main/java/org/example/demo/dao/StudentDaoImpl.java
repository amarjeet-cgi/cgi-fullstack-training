package org.example.demo.dao;

import java.util.List;

import org.example.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Student> displayAllStudent() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		List<Student> student = query.getResultList();
		for(Student s: student) {
			System.out.println(s);
		}
		session.getTransaction().commit();
		return student;
	}


	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = session.find(Student.class, id);
		if(student!=null) {
			System.out.println(student);
			
		}
		else {
			System.out.println("no such id found!!!");
		}
		session.getTransaction().commit();
		return student;
	}

	@Override
	public Student findStudentByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		Student student_obj = null;
		List<Student> student = query.getResultList();
		for(Student s: student) {
			if(s.getName().equals(name)) {
				student_obj = s;
				System.out.println(s);
			}
			else {
				student_obj = null;
				System.out.println("No such student found");
			}
		}
		session.getTransaction().commit();
		return student_obj;
	}

	@Override
	public Student updateStudentById(int id, Student newStudent) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = findStudentById(id);
		student.setName(newStudent.getName());
		student.setNatinality(newStudent.getNatinality());
		student.setCode(newStudent.getCode());
		student.setEntering_date(newStudent.getEntering_date());
		session.merge(student);
		System.out.println(student);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Student updateStudentByName(String name, Student newStudent) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = findStudentByName(name);
		student.setName(newStudent.getName());
		student.setNatinality(newStudent.getNatinality());
		student.setCode(newStudent.getCode());
		student.setEntering_date(newStudent.getEntering_date());
		session.merge(student);
		System.out.println(student);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Student findStudentByDate(String date) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		Student student_obj = null;
		List<Student> student = query.getResultList();
		for(Student s: student) {
			if(s.getEntering_date().equals(date)) {
				student_obj = s;
				System.out.println(s);
			}
			else {
				student_obj = null;
				System.out.println("No such student found");
			}
		}
		session.getTransaction().commit();
		return student_obj;
	}
	
	@Override
	public void deleteById(int id) {
		Session session=sessionFactory.openSession();
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		List<Student> student = query.getResultList();
		for(Student s: student) {
			System.out.println(id);
			if (s.getStudentId() == id ) {
				session.delete(s);
				System.out.println("Record deleted!!!");
				break;
			}
			else {
				System.out.println("id not found");
			}
		}
		session.getTransaction().commit();
		
	}


	@SuppressWarnings("rawtypes")
	@Override
	public void deleteAll() {
		Session session=sessionFactory.openSession();
		// TODO Auto-generated method stub
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student");
		@SuppressWarnings("unchecked")
		List<Student> student = query.getResultList();
		for(Student s: student) {
			
			
				session.delete(s);
				System.out.println("All Record deleted!!!");
				break;
			
		}
		session.getTransaction().commit();
	}
	
	
	
	

}
