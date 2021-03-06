package in.waheed.hibernate.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @Embeddable tells Hibernate that Address object will be embedded into some
 *             other tables.The values of the properties will be populated into
 *             a table in which we want to embed the Address
 * 
 * @author abdulwaheed18@gmail.com
 *
 */
@Embeddable
public class Address {

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
