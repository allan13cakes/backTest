package automation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestCaseStep {
	@Id
	@GeneratedValue
	private Long id;
	private Long testCaseId;
	private Long testStepId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(Long testCaseId) {
		this.testCaseId = testCaseId;
	}

	public Long getTestStepId() {
		return testStepId;
	}

	public void setTestStepId(Long testStepId) {
		this.testStepId = testStepId;
	}

}
