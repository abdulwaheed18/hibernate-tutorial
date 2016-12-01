/**
 * 
 */
package in.waheed.hibernate.mappedsuperclass;

import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author abdulwaheed18@gmail.com
 *
 */
@SuppressWarnings("deprecation")
public class Application {

	private static final SessionFactory concreteSessionFactory;
	static {
		try {
			concreteSessionFactory = new AnnotationConfiguration()
					.configure("/in/waheed/hibernate/mappedsuperclass/hibernate.cfg.xml").buildSessionFactory();
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
		User user = new User(1, Calendar.getInstance(), Calendar.getInstance(), "Abdul", "Waheed",
				"abdulwaheed18@gmail.com");
		session.save(user);
		session.getTransaction().commit();

	}

}
