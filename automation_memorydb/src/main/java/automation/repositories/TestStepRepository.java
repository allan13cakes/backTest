package automation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import automation.model.TestStep;

public interface TestStepRepository extends CrudRepository<TestStep, Long> {
	@Query(value = "select s.id, s.action_id, s.page_id,s.test_data, s.element_id, p.name as page_name, a.name as action_name, a.description as action_description,e.value as element_value, e.name as element_name from test_step s left join test_action a on s.action_id=a.id left join test_page p on p.id=s.page_id left join test_element e on e.id=s.element_id where exists (select 1 from test_case_step m where m.test_case_id=:testCaseId and m.test_step_id=s.id)", nativeQuery = true)
	public List<TestStep> findListTestStepByTestCaseId(@Param("testCaseId") Long testCaseId);
	@Query(value = "select s.id, s.action_id, s.page_id,s.test_data, s.element_id, p.name as page_name, a.name as action_name, a.description as action_description,e.value as element_value, e.name as element_name from test_step s left join test_action a on s.action_id=a.id left join test_page p on p.id=s.page_id left join test_element e on e.id=s.element_id where s.id=:id", nativeQuery = true)
	public TestStep findTestStepById(@Param("id") Long id);
}
