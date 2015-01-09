package org.ml4j.wit.api.impl.json;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Outcome {

	@JsonProperty("_text")
	private String text;

	private String metadata;

	@JsonProperty("intent")
	private String intentName;
	private Map<String, List<Entity>> entities;

	private double confidence;

	public String getIntentName() {
		return intentName;
	}

	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

	public Map<String, List<Entity>> getEntities() {
		return entities;
	}

	public void setEntities(Map<String, List<Entity>> entities) {
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

	public String toString() {
		return intentName + ":" + metadata + entities.toString();
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

}
