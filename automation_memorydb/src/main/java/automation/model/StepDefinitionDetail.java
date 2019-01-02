package automation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class StepDefinitionDetail {
	@Id
	@GeneratedValue
	private Long id;
	private Long stepDefId;
	private Long stepOrder;
	private Long actionId;
	private Long pageId;
	private Long elementId;
	private Long parameterId;
	
	@Transient
	private String actionName;
	@Transient
	private String pageName;
	@Transient
	private String elementName;
	@Transient
	private String parameterName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStepDefId() {
		return stepDefId;
	}
	public void setStepDefId(Long stepDefId) {
		this.stepDefId = stepDefId;
	}
	
	public Long getStepOrder() {
		return stepOrder;
	}
	public void setStepOrder(Long stepOrder) {
		this.stepOrder = stepOrder;
	}
	public Long getActionId() {
		return actionId;
	}
	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}
	public Long getPageId() {
		return pageId;
	}
	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}
	public Long getElementId() {
		return elementId;
	}
	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}
	public Long getParameterId() {
		return parameterId;
	}
	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}
	
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	@Override
	public String toString() {
		return "StepDefinitionDetail [id=" + id + ", stepDefId=" + stepDefId + ", stepOrder=" + stepOrder
				+ ", actionId=" + actionId + ", pageId=" + pageId + ", elementId=" + elementId + ", parameterId="
				+ parameterId + "]";
	}
	
}
