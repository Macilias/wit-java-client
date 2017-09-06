package org.ml4j.wit.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityUpdateRequest {

	private String doc;

	@JsonProperty("values")
	private List<ValueExpressions> valuesExpressions;

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
		return "EntityUpdateRequest [doc=" + doc + ", valuesExpressions=" + valuesExpressions + "]";
	}

	
	
	
	
}
