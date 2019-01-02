package automation.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import automation.model.StepDefinitionParameter;

public interface StepDefinitionParameterRepository extends CrudRepository<StepDefinitionParameter,Long>{
	public List<StepDefinitionParameter> findAllStepDefinitionParameterByStepDefId(Long stepDefId);
}
