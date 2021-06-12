package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class CreateStudentDemo {

	public static void main(String[] args) {
		
//		create session factory / create only once in whole app 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession(); 

		try {
			
//			create student object
			System.out.println("Creating object to save");
			Student std=new Student("naseema", "saifi", "theahmadkabeer@gmail.com" );
			
//			start transaction
			System.out.println("Begin session1");
			session.beginTransaction();
			
//			save object
			System.out.println("Saving data");
			session.save(std);
			
//			make commit
			System.out.println("commit session1");
			session.getTransaction().commit();
			
////			create new session for retreive data by id
//			System.out.println("Creating session2");
//			Session session2=factory.getCurrentSession();
//			
//			System.out.println("Begin session2");
//			session2.beginTransaction();
//			
//			System.out.println("Retriving data");			
//			Student std2=session2.get(Student.class, std.getId());
//			
//			System.out.println("commit session2");
//			session2.getTransaction().commit();
//			
//			System.out.println(std2);
			
			
			System.out.println("Done");
			
			
		} finally {
			factory.close();
		}

	}

}
