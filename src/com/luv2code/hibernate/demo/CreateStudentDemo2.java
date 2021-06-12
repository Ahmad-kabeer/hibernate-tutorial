package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class CreateStudentDemo2 {

	public static void main(String[] args) {
		
//		create session factory / create only once in whole app 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession(); 

		try {
			
			session.beginTransaction();
			
			java.util.List<Student> allstudent=session.createQuery("from Student s where s.lastname= 'kabeer'").getResultList();
			printObject(allstudent);
			
			java.util.List<Student> allstudent2=session.createQuery("from Student s where" + " s.lastname= 'saifi' AND s.firstname ='hina'").getResultList();
			printObject(allstudent2);
			
			
			java.util.List<Student> allstudent3=session.createQuery("from Student s where" + " s.lastname LIKE '%beer'").getResultList();
			printObject(allstudent3);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
			
		} finally {
			factory.close();
		}

	}

	private static void printObject(java.util.List<Student> allstudent) {
		for (Student s : allstudent) {
			
			System.out.println(s.getFirstname()+" "+ s.getLastname());
			
		}
	}

}
