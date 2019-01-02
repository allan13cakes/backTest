package automation.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import automation.model.StepDefinitionData;

public interface StepDefinitionDataRepository extends CrudRepository<StepDefinitionData,Long> {
	public List<StepDefinitionData> findStepDefinitionDataByRoundId(Long roundId);
	public StepDefinitionData findStepDefintionDataByRoundIdAndParameterId(Long roundId,Long parameterId);
}
