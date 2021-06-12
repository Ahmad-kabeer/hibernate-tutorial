package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class CreateStudentDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		create session factory / create only once in whole app 
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession(); 

		try {
			
			int studentId=1;
			session.beginTransaction();

			Student gettingstudent=session.get(Student.class, studentId);
			gettingstudent.setLastname("hina");
			
			session.getTransaction().commit();
			
//			OR
			
			Session session2 = factory.getCurrentSession();
			session2.beginTransaction();
			
			session2.createQuery("update Student set email ='lulu@gmail.com'").executeUpdate();
			
			session2.getTransaction().commit();
			
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
