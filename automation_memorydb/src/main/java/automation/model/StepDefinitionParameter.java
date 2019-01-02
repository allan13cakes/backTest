package automation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StepDefinitionParameter {
	@Id
	@GeneratedValue
	private Long id;
	private Long stepDefId;
	private String parameterName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStepDefId() {
		return stepDefId;
	}
	public void setStepDefId(Long stepDefId) {
		this.stepDefId = stepDefId;
	}
	
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	@Override
	public String toString() {
		return "StepDefinitionParameter [id=" + id + ", stepDefId=" + stepDefId + ", parameterName=" + parameterName + "]";
	}
	
}
