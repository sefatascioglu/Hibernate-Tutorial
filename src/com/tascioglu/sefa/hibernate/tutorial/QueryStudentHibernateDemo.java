package com.tascioglu.sefa.hibernate.tutorial;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tascioglu.sefa.hibernate.tutorial.entity.Student;

public class QueryStudentHibernateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		// using HQL
		List<Student> listAllStudents = session.createQuery("from Student").list();

//		System.out.println("\nAll Students");
//		displayStudents(listAllStudents);
//
//		listAllStudents = session.createQuery("from Student s where s.firstname = 'Meto'").list();
//
//		System.out.println("\n firstName : Meto");
//		displayStudents(listAllStudents);
//
//		listAllStudents = session.createQuery("from Student s where s.firstname = 'Meto' and s.lastname = 'Tas'").list();
//		
//		System.out.println("\n firstname Meto or latname Tas list");
//		displayStudents(listAllStudents);

		session.getTransaction().commit();

		session.close();

	}

	private static void displayStudents(List<Student> listAllStudents) {
		for (Student student : listAllStudents) {
			System.out.println(student);
		}
	}

}
