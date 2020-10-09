package hibernate.demo.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java Object
			Student student1 = new Student("Jone", "Do", "ldoe.kk@gildt.com");
			Student student2 = new Student("Bob", "Piza", "pizaa.bb@orange.com");
			Student student3 = new Student("Roy", "Yan", "yanziting@htomail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(student1);
			session.save(student2);
			session.save(student3);

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
