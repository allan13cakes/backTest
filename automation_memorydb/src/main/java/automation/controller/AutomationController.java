package automation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

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
import automation.service.AutomationService;

@RestController
public class AutomationController {
	private static final String FAILED = "failed";
	private static final String SUCCESS = "success";
	private ObjectMapper mapper;
	@Autowired
	private AutomationService automationService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public AutomationController() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test() {
		return "test";
	}

	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public @ResponseBody String saveProject(@RequestBody String value) throws Exception {
		Project project = mapper.readValue(value, Project.class);
		project.setCreatedDate(new Date());
		project = automationService.saveProject(project);
		return project != null ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/findAllProject", method = RequestMethod.GET)
	public @ResponseBody String findAllProject() throws Exception {
		List<Project> listProject = automationService.findAllProject();
		return mapper.writeValueAsString(listProject);
	}

	@RequestMapping(value = "/findProject/{id}", method = RequestMethod.GET)
	public @ResponseBody String findProjectById(@PathVariable Long id) throws Exception {
		Project project = automationService.findProjectById(id);
		return mapper.writeValueAsString(project);
	}

	@RequestMapping(value = "/deleteProject/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteProjectById(@PathVariable Long id) {
		return automationService.deleteProjectById(id) ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/saveTestCase", method = RequestMethod.POST)
	public @ResponseBody String saveTestCase(@RequestBody String value) throws Exception {
		TestCase testCase = mapper.readValue(value, TestCase.class);
		testCase.setCreatedDate(new Date());
		testCase = automationService.saveTestCase(testCase);
		return testCase != null ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/findAllTestCase/{projectId}", method = RequestMethod.GET)
	public @ResponseBody String findListTestCaseByProjectId(@PathVariable Long projectId) throws Exception {
		List<TestCase> listTestCase = automationService.findListTestCaseByProjectId(projectId);
		return mapper.writeValueAsString(listTestCase);
	}

	@RequestMapping(value = "/deleteTestCase/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteTestCaseById(@PathVariable Long id) {
		return automationService.deleteTestCaseByCaseId(id) ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/saveTestAction", method = RequestMethod.POST)
	public @ResponseBody String saveTestAction(@RequestBody String value) throws Exception {
		TestAction testAction = mapper.readValue(value, TestAction.class);
		testAction = automationService.saveTestAction(testAction);
		return testAction != null ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/findAllTestAction", method = RequestMethod.GET)
	public @ResponseBody String findAllTestAction() throws Exception {
		List<TestAction> listTestAction = automationService.findListTestAction();
		return mapper.writeValueAsString(listTestAction);
	}

	@RequestMapping(value = "/deleteTestAction/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteTestAction(@PathVariable Long id) {
		return automationService.deleteTestActionById(id) ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/saveTestPage", method = RequestMethod.POST)
	public @ResponseBody String saveTestPage(@RequestBody String value) throws Exception {
		TestPage testPage = mapper.readValue(value, TestPage.class);
		testPage = automationService.saveTestPage(testPage);
		return testPage != null ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/findAllTestPage", method = RequestMethod.GET)
	public @ResponseBody String findAllTestPage() throws Exception {
		List<TestPage> listTestPage = automationService.findListTestPage();
		return mapper.writeValueAsString(listTestPage);
	}

	@RequestMapping(value = "/deleteTestPage/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteTestPage(@PathVariable Long id) {
		return automationService.deleteTestPageById(id) ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/saveTestElement", method = RequestMethod.POST)
	public @ResponseBody String saveTestElement(@RequestBody String value) throws Exception {
		TestElement testElement = mapper.readValue(value, TestElement.class);
		testElement = automationService.saveTestElement(testElement);
		return testElement != null ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/findAllTestElement/{pageId}", method = RequestMethod.GET)
	public @ResponseBody String findAllTestElement(@PathVariable Long pageId) throws Exception {
		List<TestElement> listTestElement = automationService.findListTestElementByPageId(pageId);
		return mapper.writeValueAsString(listTestElement);
	}

	@RequestMapping(value = "/deleteTestElement/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteTestElement(@PathVariable Long id) {
		return automationService.deleteTestElementById(id) ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/saveTestStep/{testCaseId}", method = RequestMethod.POST)
	public @ResponseBody String saveTestStep(@RequestBody String value, @PathVariable Long testCaseId)
			throws Exception {
		TestStep testStep = mapper.readValue(value, TestStep.class);
		testStep = automationService.saveTestStep(testStep, testCaseId);
		return testStep != null ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/findAllTestStep/{testCaseId}", method = RequestMethod.GET)
	public @ResponseBody String findAllTestStep(@PathVariable Long testCaseId) throws Exception {
		List<TestStep> listTestStep = automationService.findListTestStepByTestCaseId(testCaseId);
		return mapper.writeValueAsString(listTestStep);
	}

	@RequestMapping(value = "/deleteTestStep/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteTestStep(@PathVariable Long id) {
		return automationService.deleteTestStepById(id) ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/saveStepDef", method = RequestMethod.POST)
	public @ResponseBody String saveStepDef(@RequestBody String value) throws Exception {
		StepDefinition stepDefinition = mapper.readValue(value, StepDefinition.class);
		stepDefinition = automationService.saveStepDef(stepDefinition);
		return stepDefinition != null ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/findAllStepDef/{projectId}", method = RequestMethod.GET)
	public @ResponseBody String findAllStepDef(@PathVariable Long projectId) throws Exception {
		List<StepDefinition> stepDefinitionList = automationService.findAllStepDefByProjectId(projectId);
		return mapper.writeValueAsString(stepDefinitionList);
	}

	@RequestMapping(value = "/saveStepDefDetail", method = RequestMethod.POST)
	public @ResponseBody String saveStepDefDetail(@RequestBody String value) throws Exception {
		logger.info("value->{}", value);
		StepDefinitionDetail stepDefinitionDetail = mapper.readValue(value, StepDefinitionDetail.class);
		// create step def parameter
		StepDefinitionParameter stepDefinitionParameter = mapper.readValue(value, StepDefinitionParameter.class);
		
		if(!StringUtils.isEmpty(stepDefinitionDetail.getParameterId())) {
			stepDefinitionParameter.setId(stepDefinitionDetail.getParameterId());
		}
		logger.info("stepDefinitionParameter->{}", stepDefinitionParameter);
		if(!StringUtils.isEmpty(stepDefinitionParameter.getParameterName())) {
			stepDefinitionParameter = automationService.saveStepDefParameter(stepDefinitionParameter);
			stepDefinitionDetail.setParameterId(stepDefinitionParameter.getId());
		}
		// create step def details
		logger.info("stepDefinitionDetail->{}", stepDefinitionDetail);
		
		stepDefinitionDetail = automationService.saveStepDefDetail(stepDefinitionDetail);
		return stepDefinitionDetail != null ? SUCCESS : FAILED;
	}

	@RequestMapping(value = "/findAllStepDefDetail/{stepDefId}", method = RequestMethod.GET)
	public @ResponseBody String findAllStepDefDetail(@PathVariable Long stepDefId) throws Exception {
		logger.info("stepDefId->{}", stepDefId);
		List<StepDefinitionDetail> stepDefinitionDetailList = automationService
				.findAllStepDefinitionDetailByStepDefId(stepDefId);

		for (StepDefinitionDetail stepDefinitionDetail : stepDefinitionDetailList) {
			// get action name
			TestAction testAction = automationService.findTestActionById(stepDefinitionDetail.getActionId());
			// get page name

			if (stepDefinitionDetail.getPageId() != null) {
				TestPage testPage = automationService.findTestPageById(stepDefinitionDetail.getPageId());
				// get element name
				TestElement testElement = automationService.findTestElementById(stepDefinitionDetail.getElementId());
				stepDefinitionDetail.setPageName(testPage.getName());
				stepDefinitionDetail.setElementName(testElement.getName());
			}

			// get parameter name
			if (stepDefinitionDetail.getParameterId() != null) {
				StepDefinitionParameter stepDefinitionParameter = automationService
						.findStepDefinitionParameterById(stepDefinitionDetail.getParameterId());
				stepDefinitionDetail.setParameterName(stepDefinitionParameter.getParameterName());
			}

			stepDefinitionDetail.setActionName(testAction.getDescription());

		}

		return mapper.writeValueAsString(stepDefinitionDetailList);
	}

	@RequestMapping(value = "/findAllStepDefinitionParameter/{stepDefId}", method = RequestMethod.GET)
	public @ResponseBody String findAllStepDefinitionParameterByStepDefId(@PathVariable Long stepDefId)
			throws Exception {
		List<StepDefinitionParameter> stepDefinitionParameterList = automationService
				.findAllStepDefParameterByStepDefId(stepDefId);
		logger.info("stepDefinitionParameterList size->{}", stepDefinitionParameterList.size());
		for (StepDefinitionParameter stepDefinitionParameter : stepDefinitionParameterList) {
			logger.info("stepDefinitionParameter->{}", stepDefinitionParameter);
		}
		return mapper.writeValueAsString(stepDefinitionParameterList);
	}

	@RequestMapping(value = "/saveStepDefData", method = RequestMethod.POST)
	public @ResponseBody String saveStepDefData(@RequestBody String value) throws Exception {
		logger.info("value -> {}", value);
		List<StepDefinitionRound> stepDefinitionRoundList = mapper.readValue(value,
				new TypeReference<ArrayList<StepDefinitionRound>>() {

				});
		logger.info("stepDefinitionRoundList size->{}", stepDefinitionRoundList.size());
		for (StepDefinitionRound stepDefinitionRound : stepDefinitionRoundList) {
			logger.info("stepDefinitionRound->{}", stepDefinitionRound);
			// save step def round
			stepDefinitionRound = automationService.saveStepDefinitionRound(stepDefinitionRound);
			// save step def round data
			List<StepDefinitionData> stepDefinitionDataList = stepDefinitionRound.getStepDefinitionDataList();
			if (stepDefinitionDataList != null) {
				for (StepDefinitionData stepDefinitionData : stepDefinitionDataList) {
					stepDefinitionData.setRoundId(stepDefinitionRound.getId());
				}
				stepDefinitionDataList = automationService.saveStepDefinitionData(stepDefinitionDataList);
				logger.info("return stepDefinitionDataList size->{}", stepDefinitionDataList.size());
			}
		}

		return SUCCESS;
	}

	@RequestMapping(value = "/findAllStepDefData/{stepDefId}", method = RequestMethod.GET)
	public @ResponseBody String findAllStepDefDataByStepDefId(@PathVariable Long stepDefId) throws Exception {
		// find step round by stepDefId
		List<StepDefinitionRound> stepDefinitionRoundList = automationService
				.findStepDefinitionRoundByStepDefId(stepDefId);
		// find step data by stepDefId and roundId
		for (StepDefinitionRound stepDefinitionRound : stepDefinitionRoundList) {
			List<StepDefinitionData> stepDefinitionDataList = automationService
					.findStepDefinitionDataByRoundId(stepDefinitionRound.getId());
			stepDefinitionRound.setStepDefinitionDataList(stepDefinitionDataList);
		}
		return mapper.writeValueAsString(stepDefinitionRoundList);
	}

	@RequestMapping(value = "/findStepDefRound/{stepDefId}", method = RequestMethod.GET)
	public @ResponseBody String findStepDefRoundByStepDefId(@PathVariable Long stepDefId) throws Exception {
		List<StepDefinitionRound> stepDefinitionRoundList = automationService
				.findStepDefinitionRoundByStepDefId(stepDefId);
		return mapper.writeValueAsString(stepDefinitionRoundList);
	}
}
