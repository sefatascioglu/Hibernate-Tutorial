package com.tascioglu.sefa.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tascioglu.sefa.hibernate.tutorial.entity.Student;

public class UpdateStudentHibernateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Student student = session.get(Student.class, 1);
		
		student.setFirstname("UpdateName");

		session.getTransaction().commit();
		
		
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		session.createQuery("update Student set email = 'bulkUpdate@gmail.com'").executeUpdate();
		
		session.getTransaction().commit();

		session.close();

	}

}
