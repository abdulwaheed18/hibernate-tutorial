package in.waheed.hibernate.mappedsuperclass;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author abdulwaheed18@gmail.com
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6442454338078592232L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Basic
	@Column(name = "CREATED_ON", updatable = false)
	private Calendar createdDate;
	@Basic
	@Column(name = "LAST_UPDATED_ON")
	private Calendar lastModifiedDate;

	public AbstractEntity() {
	}

	public AbstractEntity(Long id, Calendar createdDate, Calendar lastModifiedDate) {
		this.id = id;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Calendar lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
