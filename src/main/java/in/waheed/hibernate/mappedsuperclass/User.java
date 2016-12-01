package in.waheed.hibernate.mappedsuperclass;

import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@AttributeOverride(name = "createDate", column = @Column(name = "USER_CREATION_DATE"))
public class User extends AbstractEntity {

	private static final long serialVersionUID = 2269013995927189145L;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String LastName;

	@Column(name = "EMAIL")
	private String email;

	public User() {
	}

	public User(long id, Calendar createdDate, Calendar lastModifiedDate, String firstName, String lastName,
			String email) {
		super(id, createdDate, lastModifiedDate);
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
