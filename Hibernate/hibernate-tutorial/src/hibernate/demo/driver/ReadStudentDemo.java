package hibernate.demo.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java Object
			Student student1 = new Student("Daffy", "Swift", "daf.swift@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(student1);

			// commit the transaction
			session.getTransaction().commit();

			// find out the student's id
			System.out.println(student1.toString());

			// get a new session
			session = factory.getCurrentSession();

			// start a transaction
			session.beginTransaction();

			// retrieve the student
			Student retrievedStudent = session.get(Student.class, student1.getId());

			System.out.println(retrievedStudent.toString());

			// commit the transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
