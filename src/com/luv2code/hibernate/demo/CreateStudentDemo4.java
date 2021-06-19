package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class CreateStudentDemo4 {

	public static void main(String[] args) {
		
//		create session factory / create only once in whole app 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession(); 

		try {
			
			int id=1;
			
//			start transaction
			System.out.println("Begin session");
			session.beginTransaction();

//			delete from database						
//			Student std=session.get(Student.class, id);

			System.out.println("deleting data");
//			session.delete(std);
			session.createQuery("delete from Student where id=2").executeUpdate();
			
//			make commit
			System.out.println("commit session1");
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
		} finally {
			factory.close();
		}

	}

}
