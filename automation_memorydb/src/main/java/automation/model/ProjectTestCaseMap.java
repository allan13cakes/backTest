package automation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProjectTestCaseMap {
	@Id
	@GeneratedValue
	private Long id;
	private Long projectId;
	private Long testcaseId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getTestcaseId() {
		return testcaseId;
	}

	public void setTestcaseId(Long testcaseId) {
		this.testcaseId = testcaseId;
	}

	@Override
	public String toString() {
		return "ProjectTestCaseMap [id=" + id + ", projectId=" + projectId + ", testcaseId=" + testcaseId + "]";
	}

}
