package automation.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import automation.model.StepDefinitionRound;

public interface StepDefinitionRoundRepository extends CrudRepository<StepDefinitionRound,Long>{
	public List<StepDefinitionRound> findStepDefinitionRoundByStepDefId(Long stepDefId);
}
