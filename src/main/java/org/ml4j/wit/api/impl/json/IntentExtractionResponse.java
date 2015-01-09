package org.ml4j.wit.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntentExtractionResponse {

	@JsonProperty("_text")
	private String text;
	private List<Outcome> outcomes;

	@JsonProperty("msg_id")
	private String messageId;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Outcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<Outcome> outcomes) {
		this.outcomes = outcomes;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String toString() {
		return outcomes.toString();
	}

}
