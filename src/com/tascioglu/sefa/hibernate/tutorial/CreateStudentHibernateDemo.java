package com.tascioglu.sefa.hibernate.tutorial;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tascioglu.sefa.hibernate.tutorial.entity.Student;

public class CreateStudentHibernateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(new Student("Tarihli_1", "Tas",new SimpleDateFormat().getCalendar().getTime() , "email@gmail.com"));
		session.save(new Student("Tarihli_2", "Tas",new SimpleDateFormat().getCalendar().getTime(), "email@gmail.com"));

		session.getTransaction().commit();
		
		
		session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("tarihli : "+session.get(Student.class, 3));

		session.close();

	}

}
