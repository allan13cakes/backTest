package automation.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import automation.model.TestElement;

public interface TestElementRepository extends CrudRepository<TestElement,Long>{
	public List<TestElement> findAllTestElementByPageId(Long pageId);
}
