package automation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class StepDefinitionRound {
	@Id
	@GeneratedValue
	private Long id;
	private Long stepDefId;
	private String roundName;
	@Transient
	private List<StepDefinitionData> stepDefinitionDataList;

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

	public String getRoundName() {
		return roundName;
	}

	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}

	public List<StepDefinitionData> getStepDefinitionDataList() {
		return stepDefinitionDataList;
	}

	public void setStepDefinitionDataList(List<StepDefinitionData> stepDefinitionDataList) {
		this.stepDefinitionDataList = stepDefinitionDataList;
	}

	@Override
	public String toString() {
		return "StepDefinitionRound [id=" + id + ", stepDefId=" + stepDefId + ", roundName=" + roundName
				+ ", stepDefinitionDataList=" + stepDefinitionDataList + "]";
	}

}
