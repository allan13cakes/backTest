package automation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import automation.utils.DateUtils;

@Entity
public class TestCase {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String automationStatus;
	private String automationReview;
	private Date createdDate;
	private Date updatedDate;
	private String comments;
	@Transient
	private Long projectId;
	@Transient
	private String createdDateStr;
	@Transient
	private String updatedDateStr;

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

	public String getAutomationStatus() {
		return automationStatus;
	}

	public void setAutomationStatus(String automationStatus) {
		this.automationStatus = automationStatus;
	}

	public String getAutomationReview() {
		return automationReview;
	}

	public void setAutomationReview(String automationReview) {
		this.automationReview = automationReview;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatedDateStr() {
		return createdDate!=null?DateUtils.format(createdDate.getTime(), DateUtils.PATTERN_DEFAULT):"";
	}

	public String getUpdatedDateStr() {
		return updatedDate!=null?DateUtils.format(updatedDate.getTime(), DateUtils.PATTERN_DEFAULT):"";
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "TestCase [id=" + id + ", name=" + name + ", automationStatus=" + automationStatus
				+ ", automationReview=" + automationReview + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", comments=" + comments + ", projectId=" + projectId + ", createdDateStr="
				+ createdDateStr + ", updatedDateStr=" + updatedDateStr + "]";
	}

}
