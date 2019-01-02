package automation.service;

import java.util.List;

import automation.model.Project;
import automation.model.StepDefinition;
import automation.model.StepDefinitionData;
import automation.model.StepDefinitionDetail;
import automation.model.StepDefinitionParameter;
import automation.model.StepDefinitionRound;
import automation.model.TestAction;
import automation.model.TestCase;
import automation.model.TestElement;
import automation.model.TestPage;
import automation.model.TestStep;

public interface AutomationService {
	public Project saveProject(Project project);

	public List<Project> findAllProject();
	
	public Project findProjectById(Long id);

	public boolean deleteProjectById(Long projectId);

	public TestCase saveTestCase(TestCase testCase);

	public List<TestCase> findListTestCaseByProjectId(Long projectId);

	public boolean deleteTestCaseByCaseId(Long testCaseId);

	public TestStep saveTestStep(TestStep testStep, Long testCaseId);

	public List<TestStep> findListTestStepByTestCaseId(Long testCaseId);
	
	public TestStep findTestStepById(Long id);

	public boolean deleteTestStepById(Long id);

	public TestPage saveTestPage(TestPage testPage);

	public List<TestPage> findListTestPage();

	public TestPage findTestPageById(Long id);
	
	public boolean deleteTestPageById(Long id);

	public TestElement saveTestElement(TestElement element);

	public List<TestElement> findListTestElementByPageId(Long pageId);
	
	public TestElement findTestElementById(Long id);

	public boolean deleteTestElementById(Long id);

	public TestAction saveTestAction(TestAction testAction);

	public List<TestAction> findListTestAction();
	
	public TestAction findTestActionById(Long id);

	public boolean deleteTestActionById(Long id);
	
	public StepDefinition saveStepDef(StepDefinition stepDefinition);
	
	public List<StepDefinition> findAllStepDefByProjectId(Long projectId);
	
	public StepDefinitionParameter saveStepDefParameter(StepDefinitionParameter stepDefinitionParameter);
	
	public StepDefinitionDetail saveStepDefDetail(StepDefinitionDetail stepDefinitionDetail);
	
	public List<StepDefinitionParameter> findAllStepDefParameterByStepDefId(Long stepDefId);
	
	public StepDefinitionParameter findStepDefinitionParameterById(Long id);
	
	public List<StepDefinitionDetail> findAllStepDefinitionDetailByStepDefId(Long stepDefId);
	
	public StepDefinitionDetail findStepDefinitionDetailById(Long id);
	
	public StepDefinitionRound saveStepDefinitionRound(StepDefinitionRound stepDefinitionRound);
	
	public List<StepDefinitionData> saveStepDefinitionData(List<StepDefinitionData> stepDefinitionDataList);
	
	public List<StepDefinitionRound> findStepDefinitionRoundByStepDefId(Long stepDefId);
	
	public List<StepDefinitionData> findStepDefinitionDataByRoundId(Long roundId);
	
	public StepDefinitionData findStepDefinitionDataByRoundIdAndParameterId(Long roundId,Long parameterId);
	
}
