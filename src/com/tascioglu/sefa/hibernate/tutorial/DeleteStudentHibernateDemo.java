package com.tascioglu.sefa.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tascioglu.sefa.hibernate.tutorial.entity.Student;

public class DeleteStudentHibernateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Student student = session.get(Student.class, 1);
		
		session.delete(student);
		
		
		session.getTransaction().commit();
		
		
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		session.createQuery("delete from Student where id = '2'").executeUpdate();
		
		session.getTransaction().commit();

		session.close();

	}

}
