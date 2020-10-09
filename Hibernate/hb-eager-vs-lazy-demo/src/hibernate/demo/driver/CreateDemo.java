package hibernate.demo.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

//			Instructor instructor = new Instructor("Jinchen", "Hu", "jinchen.hu@gmail.com");
//
//			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.jhc", "reading, jogging");
//
//			instructor.setInstructorDetail(instructorDetail);

			Instructor instructor = new Instructor("Steve", "Constanio", "c.steve@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.cs", "extreme sporting, video games");

			instructor.setInstructorDetail(instructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor -- also save instructorDetail due to cascading all
			session.save(instructor);

			System.out.println(instructor);
			// commit the transaction
			session.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
