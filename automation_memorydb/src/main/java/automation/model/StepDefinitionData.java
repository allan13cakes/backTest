package automation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StepDefinitionData {
	@Id
	@GeneratedValue
	private Long id;
	private Long stepDefId;
	private Long roundId;
	private Long parameterId;
	private String value;

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

	public Long getRoundId() {
		return roundId;
	}

	public void setRoundId(Long roundId) {
		this.roundId = roundId;
	}

	public Long getParameterId() {
		return parameterId;
	}

	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "StepDefinitionData [id=" + id + ", stepDefId=" + stepDefId + ", parameterId=" + parameterId + ", value="
				+ value + "]";
	}

}
