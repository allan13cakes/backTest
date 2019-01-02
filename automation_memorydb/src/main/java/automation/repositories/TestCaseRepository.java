package automation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import automation.model.TestCase;

public interface TestCaseRepository extends CrudRepository<TestCase, Long> {
	@Query(value = "select t.* from test_case t where exists (select 1 from project_test_case_map m where m.testcase_id=t.id and m.project_id=:projectId)", nativeQuery = true)
	public List<TestCase> findListTestCaseByProjectId(@Param("projectId") Long projectId);
}
