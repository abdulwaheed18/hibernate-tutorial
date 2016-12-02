package in.waheed.hibernate.embeddable;

import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import in.waheed.hibernate.mappedsuperclass.User;

public class Application {

	private static final SessionFactory concreteSessionFactory;
	static {
		try {
			concreteSessionFactory = new AnnotationConfiguration()
					.configure("/in/waheed/hibernate/embeddable/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return concreteSessionFactory.openSession();
	}

	public static void main(String[] args) {
		Session session = getSession();
		session.beginTransaction();
		Address studentAddress = new Address();
		studentAddress.setCity("PUNE");
		studentAddress.setState("MAHARASHTRA");
		studentAddress.setStreet("UNKNOWN_STREET");
		studentAddress.setZipCode("123456");

		Address professorAddress = new Address();
		professorAddress.setCity("VARANASI");
		professorAddress.setState("UP");
		professorAddress.setStreet("UNKNOWN_STREET");
		professorAddress.setZipCode("123456");

		Student student = new Student();
		student.setName("ABDUL");
		student.setId(10);
		student.setAddress(studentAddress);

		Professor professor = new Professor();
		professor.setName("WAHEED");
		professor.setId(100);
		professor.setAddress(studentAddress);

		session.save(professor);
		session.save(student);

		session.getTransaction().commit();

	}

}
