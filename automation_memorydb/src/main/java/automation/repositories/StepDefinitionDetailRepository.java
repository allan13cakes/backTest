package automation.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import automation.model.StepDefinitionDetail;

public interface StepDefinitionDetailRepository extends CrudRepository<StepDefinitionDetail,Long>{
	public List<StepDefinitionDetail> findAllStepDefinitionDetailByStepDefId(Long stepDefId);
}
