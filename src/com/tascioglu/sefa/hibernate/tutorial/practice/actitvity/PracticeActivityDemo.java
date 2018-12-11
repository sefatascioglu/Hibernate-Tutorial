package com.tascioglu.sefa.hibernate.tutorial.practice.actitvity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tascioglu.sefa.hibernate.tutorial.entity.Employee;

public class PracticeActivityDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.practice.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Employee employee = new Employee("Sefa", "Tas", "Linkt");
		
		session.save(employee);
		
		session.getTransaction().commit();
		
		session.close();
		
		factory.close();
		

	}

}
