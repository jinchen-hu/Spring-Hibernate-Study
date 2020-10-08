package hibernate.demo.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// retrieve a student by id=1
			Student student = session.get(Student.class, 1);
			student.setLastName("Wu");
			student.setFirstName("Wood");
			student.setEmail("w.w@qq.com");

			// commit the transaction
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("update Student s set email='w.wu@gmail.com' where s.email='w.w@qq.com'")
					.executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
