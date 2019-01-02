package automation.controller;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import automation.client.SeleniumClient;
import automation.model.StepDefinitionData;
import automation.model.StepDefinitionDetail;
import automation.model.StepDefinitionParameter;
import automation.model.TestAction;
import automation.model.TestElement;
import automation.model.TestPage;
import automation.model.TestStep;
import automation.service.AutomationService;

@RestController
public class ExecutionController {
	private static final String SUCCESS = "success";
	private SeleniumClient client = new SeleniumClient();
	@Autowired
	private AutomationService automationService;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/startRunStep", method = RequestMethod.GET)
	public @ResponseBody String startRunStep() {
		client.initialize();
		return SUCCESS;
	}

	@RequestMapping(value = "/runStep/{stepId}", method = RequestMethod.GET)
	public @ResponseBody String runStepById(@PathVariable Long stepId) throws Exception {
		TestStep testStep = automationService.findTestStepById(stepId);

		execute(testStep.getActionDescription(), testStep.getTestData(), testStep.getElementValue());
		return SUCCESS;
	}

	private void execute(String methodName, String testData, String locator) throws Exception {
		Method[] methods = client.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Object[] params = new Object[method.getParameterCount()];
				if (!StringUtils.isEmpty(locator)) {
					params[0] = locator;
				}
				if (!StringUtils.isEmpty(testData)) {
					if (method.getParameterCount() > 1) {
						params[1] = testData;
					} else {
						params[0] = testData;
					}
				}
				method.invoke(client, params);
				break;
			}
		}
	}

	@RequestMapping(value = "/runAllStep/{caseId}", method = RequestMethod.GET)
	public @ResponseBody String runAllStepByCaseId(@PathVariable Long caseId) throws Exception {
		List<TestStep> listTestStep = automationService.findListTestStepByTestCaseId(caseId);
		for (TestStep testStep : listTestStep) {
			Method[] methods = client.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().equals(testStep.getActionDescription())) {
					if (StringUtils.isEmpty(testStep.getTestData())) {
						Object[] params = { testStep.getElementValue(), testStep.getTestData() };
						method.invoke(client, params);
					} else {
						Object[] params = { testStep.getElementValue() };
						method.invoke(client, params);
					}
					break;
				}
			}
		}
		return SUCCESS;
	}

	@RequestMapping(value = "/runStepDefDetail/{stepDefDetailId}/{roundId}", method = RequestMethod.GET)
	public @ResponseBody String runStepDefDetailByDetailId(@PathVariable("stepDefDetailId") Long stepDefDetailId,
			@PathVariable("roundId") Long roundId) throws Exception {
		StepDefinitionDetail stepDefinitionDetail = automationService.findStepDefinitionDetailById(stepDefDetailId);
		logger.info("stepDefinitionDetail->{}", stepDefinitionDetail);
		String dataValue = "";
		String elementValue = "";
		// get action name
		TestAction testAction = automationService.findTestActionById(stepDefinitionDetail.getActionId());

		if (stepDefinitionDetail.getPageId() != null) {
			// get page name
			// TestPage testPage =
			// automationService.findTestPageById(stepDefinitionDetail.getPageId());
			// get element name
			TestElement testElement = automationService.findTestElementById(stepDefinitionDetail.getElementId());
			elementValue = testElement.getValue();
		}

		if (stepDefinitionDetail.getParameterId() != null) {
			// get parameter name
			StepDefinitionParameter stepDefinitionParameter = automationService
					.findStepDefinitionParameterById(stepDefinitionDetail.getParameterId());
			// get test data by roundId and parameterId
			StepDefinitionData stepDefinitionData = automationService
					.findStepDefinitionDataByRoundIdAndParameterId(roundId, stepDefinitionParameter.getId());
			dataValue = stepDefinitionData != null ? stepDefinitionData.getValue() : null;
		}

		execute(testAction.getName(), dataValue, elementValue);
		return SUCCESS;
	}

	@RequestMapping(value = "/runAllStepDefDetail/{stepDefId}/{roundId}", method = RequestMethod.GET)
	public @ResponseBody String runAllStepDefDetailByDefId(@PathVariable("stepDefId") Long stepDefId,
			@PathVariable("roundId") Long roundId) throws Exception {
		List<StepDefinitionDetail> stepDefinitionDetailList = automationService
				.findAllStepDefinitionDetailByStepDefId(stepDefId);
		for (StepDefinitionDetail stepDefinitionDetail : stepDefinitionDetailList) {
			logger.info("stepDefinitionDetail->{}", stepDefinitionDetail);
			// get action name
			TestAction testAction = automationService.findTestActionById(stepDefinitionDetail.getActionId());
			// get page name
			TestPage testPage = automationService.findTestPageById(stepDefinitionDetail.getPageId());
			// get element name
			TestElement testElement = automationService.findTestElementById(stepDefinitionDetail.getElementId());
			// get parameter name
			StepDefinitionParameter stepDefinitionParameter = automationService
					.findStepDefinitionParameterById(stepDefinitionDetail.getParameterId());
			logger.info("Action description->{},Page Name->{},Element name->{},step Definition Parameter->{}",
					testAction.getDescription(), testPage.getName(), testElement.getName(),
					stepDefinitionParameter.getParameterName());

			// get test data by roundId and parameterId
			StepDefinitionData stepDefinitionData = automationService
					.findStepDefinitionDataByRoundIdAndParameterId(roundId, stepDefinitionParameter.getId());
			execute(testAction.getName(), stepDefinitionData != null ? stepDefinitionData.getValue() : null,
					testElement.getValue());
		}
		return SUCCESS;
	}

	@RequestMapping(value = "/endRunStep", method = RequestMethod.GET)
	public @ResponseBody String endRunStep() {
		client.quit();
		return SUCCESS;
	}
}
