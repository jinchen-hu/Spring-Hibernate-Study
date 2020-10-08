package hibernate.demo.driver;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> students = session.createQuery("from Student").list();

			// display students
			displayStudents(students);

			// query student whose last name is Do
			students = session.createQuery("from Student s where s.lastName='Do'").list();

			// display students
			displayStudents(students);

			// query student whose last name is Yan or first name is Bob
			students = session.createQuery("from Student s where" + " s.lastName='Yan' OR s.firstName='Bob'").list();
			displayStudents(students);

			// query student whose email ends up with gmail.com
			students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			displayStudents(students);

			// commit the transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

}
