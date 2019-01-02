package automation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestAction {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private String parameterOneType;
	private String parameterTwoType;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParameterOneType() {
		return parameterOneType;
	}

	public void setParameterOneType(String parameterOneType) {
		this.parameterOneType = parameterOneType;
	}

	public String getParameterTwoType() {
		return parameterTwoType;
	}

	public void setParameterTwoType(String parameterTwoType) {
		this.parameterTwoType = parameterTwoType;
	}


}
