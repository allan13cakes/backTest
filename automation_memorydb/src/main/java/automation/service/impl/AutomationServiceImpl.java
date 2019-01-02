package automation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automation.model.Project;
import automation.model.ProjectTestCaseMap;
import automation.model.StepDefinition;
import automation.model.StepDefinitionData;
import automation.model.StepDefinitionDetail;
import automation.model.StepDefinitionParameter;
import automation.model.StepDefinitionRound;
import automation.model.TestAction;
import automation.model.TestCase;
import automation.model.TestCaseStep;
import automation.model.TestElement;
import automation.model.TestPage;
import automation.model.TestStep;
import automation.repositories.ProjectRepository;
import automation.repositories.ProjectTestCaseMapRepository;
import automation.repositories.StepDefinitionDataRepository;
import automation.repositories.StepDefinitionDetailRepository;
import automation.repositories.StepDefinitionParameterRepository;
import automation.repositories.StepDefinitionRepository;
import automation.repositories.StepDefinitionRoundRepository;
import automation.repositories.TestActionRepository;
import automation.repositories.TestCaseRepository;
import automation.repositories.TestCaseStepRepository;
import automation.repositories.TestElementRepository;
import automation.repositories.TestPageRepository;
import automation.repositories.TestStepRepository;
import automation.service.AutomationService;

@Service
public class AutomationServiceImpl implements AutomationService {
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectTestCaseMapRepository projectTestCaseMapRepository;

	@Autowired
	private TestCaseRepository testCaseRepository;

	@Autowired
	private TestActionRepository testActionRepository;

	@Autowired
	private TestCaseStepRepository testCaseStepRepository;

	@Autowired
	private TestElementRepository testElementRepository;

	@Autowired
	private TestPageRepository testPageRepository;

	@Autowired
	private TestStepRepository testStepRepository;

	@Autowired
	private StepDefinitionRepository stepDefinitionRepository;

	@Autowired
	private StepDefinitionDetailRepository stepDefinitionDetailRepository;

	@Autowired
	private StepDefinitionParameterRepository stepDefinitionParameterRepository;

	@Autowired
	private StepDefinitionRoundRepository stepDefinitionRoundRepository;

	@Autowired
	private StepDefinitionDataRepository stepDefinitionDataRepository;

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public List<Project> findAllProject() {
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public boolean deleteProjectById(Long projectId) {
		if (projectRepository.existsById(projectId)) {
			projectRepository.deleteById(projectId);
		}
		return projectRepository.existsById(projectId);
	}

	@Override
	public TestCase saveTestCase(TestCase testCase) {
		TestCase returnTestCase = testCaseRepository.save(testCase);
		ProjectTestCaseMap projectTestCaseMap = new ProjectTestCaseMap();
		projectTestCaseMap.setProjectId(testCase.getProjectId());
		projectTestCaseMap.setTestcaseId(returnTestCase.getId());
		projectTestCaseMapRepository.save(projectTestCaseMap);
		return returnTestCase;
	}

	@Override
	public List<TestCase> findListTestCaseByProjectId(Long projectId) {
		return testCaseRepository.findListTestCaseByProjectId(projectId);
	}

	@Override
	public boolean deleteTestCaseByCaseId(Long testCaseId) {
		testCaseRepository.deleteById(testCaseId);
		return testCaseRepository.existsById(testCaseId);
	}

	@Override
	public TestStep saveTestStep(TestStep testStep, Long testCaseId) {
		TestStep newStep = testStepRepository.save(testStep);
		TestCaseStep testCaseStep = testCaseStepRepository.findTestCaseStepByTestStepId(testStep.getId());
		if (testCaseStep == null) {
			testCaseStep = new TestCaseStep();
			testCaseStep.setTestCaseId(testCaseId);
			testCaseStep.setTestStepId(testStep.getId());
			testCaseStepRepository.save(testCaseStep);
		}
		return newStep;
	}

	@Override
	public List<TestStep> findListTestStepByTestCaseId(Long testCaseId) {
		return testStepRepository.findListTestStepByTestCaseId(testCaseId);
	}

	@Override
	public boolean deleteTestStepById(Long id) {
		testStepRepository.deleteById(id);
		return testStepRepository.existsById(id);
	}

	@Override
	public TestPage saveTestPage(TestPage testPage) {
		return testPageRepository.save(testPage);
	}

	@Override
	public List<TestPage> findListTestPage() {
		return (List<TestPage>) testPageRepository.findAll();
	}

	@Override
	public boolean deleteTestPageById(Long id) {
		testPageRepository.deleteById(id);
		return testPageRepository.existsById(id);
	}

	@Override
	public TestElement saveTestElement(TestElement element) {
		return testElementRepository.save(element);
	}

	@Override
	public List<TestElement> findListTestElementByPageId(Long pageId) {
		return testElementRepository.findAllTestElementByPageId(pageId);
	}

	@Override
	public boolean deleteTestElementById(Long id) {
		testElementRepository.deleteById(id);
		return testElementRepository.existsById(id);
	}

	@Override
	public TestAction saveTestAction(TestAction testAction) {
		return testActionRepository.save(testAction);
	}

	@Override
	public List<TestAction> findListTestAction() {
		return (List<TestAction>) testActionRepository.findAll();
	}

	@Override
	public boolean deleteTestActionById(Long id) {
		testActionRepository.deleteById(id);
		return testActionRepository.existsById(id);
	}

	@Override
	public TestStep findTestStepById(Long id) {
		return testStepRepository.findTestStepById(id);
	}

	@Override
	public StepDefinition saveStepDef(StepDefinition stepDefinition) {
		return stepDefinitionRepository.save(stepDefinition);
	}

	@Override
	public List<StepDefinition> findAllStepDefByProjectId(Long projectId) {
		return stepDefinitionRepository.findAllStepDefinitionByProjectId(projectId);
	}

	@Override
	public StepDefinitionParameter saveStepDefParameter(StepDefinitionParameter stepDefinitionParameter) {
		return stepDefinitionParameterRepository.save(stepDefinitionParameter);
	}

	@Override
	public StepDefinitionDetail saveStepDefDetail(StepDefinitionDetail stepDefinitionDetail) {
		return stepDefinitionDetailRepository.save(stepDefinitionDetail);
	}

	@Override
	public List<StepDefinitionParameter> findAllStepDefParameterByStepDefId(Long stepDefId) {
		return stepDefinitionParameterRepository.findAllStepDefinitionParameterByStepDefId(stepDefId);
	}

	@Override
	public List<StepDefinitionDetail> findAllStepDefinitionDetailByStepDefId(Long stepDefId) {
		return stepDefinitionDetailRepository.findAllStepDefinitionDetailByStepDefId(stepDefId);
	}

	@Override
	public TestPage findTestPageById(Long id) {
		Optional<TestPage> optional = testPageRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public TestElement findTestElementById(Long id) {
		Optional<TestElement> optional = testElementRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public TestAction findTestActionById(Long id) {
		Optional<TestAction> optional = testActionRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public StepDefinitionParameter findStepDefinitionParameterById(Long id) {
		Optional<StepDefinitionParameter> optional = stepDefinitionParameterRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public StepDefinitionDetail findStepDefinitionDetailById(Long id) {
		Optional<StepDefinitionDetail> optional = stepDefinitionDetailRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Project findProjectById(Long id) {
		Optional<Project> optional = projectRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public StepDefinitionRound saveStepDefinitionRound(StepDefinitionRound stepDefinitionRound) {
		return stepDefinitionRoundRepository.save(stepDefinitionRound);
	}

	@Override
	public List<StepDefinitionData> saveStepDefinitionData(List<StepDefinitionData> stepDefinitionDataList) {
		return (List<StepDefinitionData>) stepDefinitionDataRepository.saveAll(stepDefinitionDataList);
	}

	@Override
	public List<StepDefinitionRound> findStepDefinitionRoundByStepDefId(Long stepDefId) {
		return stepDefinitionRoundRepository.findStepDefinitionRoundByStepDefId(stepDefId);
	}

	@Override
	public List<StepDefinitionData> findStepDefinitionDataByRoundId(Long roundId) {
		return stepDefinitionDataRepository.findStepDefinitionDataByRoundId(roundId);
	}

	@Override
	public StepDefinitionData findStepDefinitionDataByRoundIdAndParameterId(Long roundId, Long parameterId) {
		return stepDefinitionDataRepository.findStepDefintionDataByRoundIdAndParameterId(roundId, parameterId);
	}

}
