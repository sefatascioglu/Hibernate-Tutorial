package com.tascioglu.sefa.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tascioglu.sefa.hibernate.tutorial.entity.Student;

public class ReadStudentHibernateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();

			Student student = new Student("Reading", "Student", "email@gmail.com");
			session.save(student);

			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student readStudent = session.get(Student.class, student.getId());

			System.out.println("Read Student :  "+readStudent);
		} finally {
			session.close();
			factory.close();
		}
		
		
		
		

	}

}
