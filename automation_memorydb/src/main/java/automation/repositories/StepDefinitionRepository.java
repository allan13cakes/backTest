package automation.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import automation.model.StepDefinition;

public interface StepDefinitionRepository extends CrudRepository<StepDefinition,Long>{
	public List<StepDefinition> findAllStepDefinitionByProjectId(Long projectId);
}
