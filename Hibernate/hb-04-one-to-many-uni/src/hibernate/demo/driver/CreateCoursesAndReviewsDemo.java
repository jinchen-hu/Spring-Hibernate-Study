package hibernate.demo.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			Course course = new Course("PHIC776");

			Review review1 = new Review("Good Course");
			Review review2 = new Review("Awesome Course");
			Review review3 = new Review("Bad Course");

			course.addReview(review1);
			course.addReview(review2);
			course.addReview(review3);

			System.out.println(course);
			System.out.println(course.getReviews());

			session.save(course);

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
