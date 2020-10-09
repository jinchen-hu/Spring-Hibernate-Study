package hibernate.demo.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 2);

			System.out.println(instructor);

			System.out.println(instructor.getCourses());

			// commit the transaction
			session.getTransaction().commit();
			session.close();
			System.out.println(instructor);

			System.out.println(instructor.getCourses());
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			factory.close();
		}

	}

}
