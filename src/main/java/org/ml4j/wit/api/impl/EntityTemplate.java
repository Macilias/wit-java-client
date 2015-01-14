/*
 s* Copyright 201 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ml4j.wit.api.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.ml4j.wit.api.EntityOperations;
import org.ml4j.wit.api.impl.json.EntityCreationRequest;
import org.ml4j.wit.api.impl.json.EntityNameListResponse;
import org.ml4j.wit.api.impl.json.EntityResponse;
import org.ml4j.wit.api.impl.json.EntityUpdateRequest;
import org.ml4j.wit.api.impl.json.ValueCreationRequest;
import org.springframework.web.client.RestTemplate;

/**
 * @author Michael Lavelle
 */
public class EntityTemplate extends AbstractWitResourceOperations implements EntityOperations {

	public EntityTemplate(String oauthApiBaseUrl, RestTemplate restTemplate, String version) {
		super(oauthApiBaseUrl, restTemplate, version);
	}

	@Override
	protected String getApiResourceBaseUrl() {
		return getApiBaseUrl();
	}

	@Override
	public List<String> getEntityNames() {
		return restTemplate.getForObject(getApiResourceUrl("/entities"), EntityNameListResponse.class);
	}

	@Override
	public EntityResponse getEntityByNameOrId(String entityNameOrId) {
		return restTemplate.getForObject(getApiResourceUrl("/entities/" + entityNameOrId), EntityResponse.class);
	}

	@Override
	public EntityResponse createEntity(EntityCreationRequest entityAttributes) {
		return restTemplate.postForObject(getApiResourceUrl("/entities"), entityAttributes, EntityResponse.class);
	}

	@Override
	public void updateEntity(String entityId, EntityUpdateRequest entityUpdateRequest) {
		restTemplate.put(getApiResourceUrl("/entities/" + entityId), entityUpdateRequest);;
	}

	@Override
	public void createEntityValue(String entityId, ValueCreationRequest request) {
		restTemplate.postForObject(getApiResourceUrl("/entities/" + entityId + "/values"), request, EntityResponse.class);
	}

	@Override
	public void addEntityExpression(String entityId, String entityValue, String expressionValue) {
		restTemplate.postForObject(getApiResourceUrl("/entities/" + entityId + "/values/" + entityValue + "/expressions"), new ExpressionValue(expressionValue), EntityResponse.class);		
	}

	@Override
	public void deleteEntityValue(String entityId, String value) {
		restTemplate.delete(getApiResourceUrl("/entities/" + entityId + "/values/" + value));
	}

	@Override
	public void deleteEntityExpression(String entityId, String entityValue, String expressionValue) {
		restTemplate.delete(getApiResourceUrl("/entities/" + entityId + "/values/" + entityValue + "/" + encode(expressionValue)));
	}
	
	private String encode(String s)
	{
		try {
			return URLEncoder.encode(s,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	
	

}
