package org.ml4j.wit.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Expression {

	private String id;
	private String body;

	private List<ExpressionEntity> entities;

	public List<ExpressionEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<ExpressionEntity> entities) {
		this.entities = entities;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Expression [id=" + id + ", body=" + body + ", entities=" + entities + "]";
	}

}
