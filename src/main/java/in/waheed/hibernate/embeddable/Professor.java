package in.waheed.hibernate.embeddable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESSOR")
public class Professor {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "PROFESSOR_NAME")
	private String name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "PROFESSOR_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "PROFESSOR_CITY_NAME")),
			@AttributeOverride(name = "state", column = @Column(name = "PROFESSOR_STATE_NAME")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "PROFESSOR_ZIP_CODE")) })
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
