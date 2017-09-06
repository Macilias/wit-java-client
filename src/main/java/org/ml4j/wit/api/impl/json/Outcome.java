package org.ml4j.wit.api.impl.json;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Outcome {

	@JsonProperty("_text")
	private String text;
	private String metadata;
	@JsonProperty("intent")
	private String intentName;
	private Map<String, List<EntityValue>> entities;

	private double confidence;

	public String getIntentName() {
		return intentName;
	}

	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

	public Map<String, List<EntityValue>> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, List<EntityValue>> entities) {
		this.entities = entities;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Outcome [text=" + text + ", metadata=" + metadata + ", intentName=" + intentName + ", entities="
				+ entities + ", confidence=" + confidence + "]";
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

}
