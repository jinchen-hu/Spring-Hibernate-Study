package hibernate.demo.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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

			Course course1 = new Course("COMP 249");
			// Course course2 = new Course("COMP 345");
			// Course course3 = new Course("COMP 432");
			System.out.println("Save course ...");
			session.save(course1);
			System.out.println(course1);

			Student student1 = new Student("Karl", "Philips", "k.lip@gamil.com");
			Student student2 = new Student("Maya", "Loo", "maya.o@gamil.com");
			Student student3 = new Student("Cristina", "Diocs", "tina.di@hotmail.com");

			course1.addStudent(student1);
			course1.addStudent(student2);
			course1.addStudent(student3);
			System.out.println("Save student ...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			System.out.println(course1.getStudents());

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
