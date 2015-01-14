package org.ml4j.wit.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityCreationRequest {

	@JsonProperty("id")
	private String name;
	private String doc;


	@JsonProperty("values")
	private List<ValueExpressions> valuesExpressions;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public List<ValueExpressions> getValuesExpressions() {
		return valuesExpressions;
	}

	public void setValuesExpressions(List<ValueExpressions> valuesExpressions) {
		this.valuesExpressions = valuesExpressions;
	}

	@Override
	public String toString() {
		return "EntityAttributes [name=" + name + ", doc=" + doc + ", valuesExpressions=" + valuesExpressions + "]";
	}
	
	
	
	
}
