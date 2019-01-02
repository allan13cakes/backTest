package automation.repositories;

import org.springframework.data.repository.CrudRepository;

import automation.model.TestCaseStep;

public interface TestCaseStepRepository extends CrudRepository<TestCaseStep, Long> {
	public TestCaseStep findTestCaseStepByTestStepId(Long testStepId);
}
