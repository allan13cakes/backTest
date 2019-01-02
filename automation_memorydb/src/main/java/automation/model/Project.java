package automation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import automation.utils.DateUtils;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Date createdDate;
	@Transient
	private String createdDateStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedDateStr() {
		return DateUtils.format(createdDate.getTime(), DateUtils.PATTERN_DEFAULT);
	}

	public Project() {
		super();
	}

	public Project(String name, Date createdDate) {
		super();
		this.name = name;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", createdDateStr="
				+ createdDateStr + "]";
	}

}
