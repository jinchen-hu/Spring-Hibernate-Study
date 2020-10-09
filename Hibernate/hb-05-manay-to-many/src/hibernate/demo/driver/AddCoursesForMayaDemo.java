package hibernate.demo.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class AddCoursesForMayaDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			Course course2 = new Course("COMP 388");
			Course course3 = new Course("COMP 499");

			// get maya
			Student maya = session.get(Student.class, 3);
			System.out.println(maya.getCourses());

			// save course
			course2.addStudent(maya);
			course3.addStudent(maya);

			session.save(course2);
			session.save(course3);

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
