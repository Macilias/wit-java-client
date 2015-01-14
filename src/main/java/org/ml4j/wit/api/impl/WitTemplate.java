/*
 * Copyright 2015 the original author or authors.
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

import java.util.List;

import org.ml4j.wit.api.EntityOperations;
import org.ml4j.wit.api.IntentExtractionOperations;
import org.ml4j.wit.api.IntentOperations;
import org.ml4j.wit.api.Wit;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

/**
 * @author Michael Lavelle
 */
public class WitTemplate extends AbstractOAuth2ApiBinding implements Wit {

	private IntentExtractionOperations intentExtractionOperations;
	
	private IntentOperations intentOperations;

	private EntityOperations entityOperations;


	private String version = "20150109";

	/**
	 * Create a new instance of WitTemplate. This constructor creates the
	 * WitTemplate using a given access token
	 * 
	 * @param accessToken
	 */
	public WitTemplate(String accessToken) {
		super(accessToken);
		initialize("https://api.wit.ai", accessToken);
	}

	@Override
	protected List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> messageConverters = super
				.getMessageConverters();
		messageConverters.add(new ResourceHttpMessageConverter());
		return messageConverters;
	}

	private void initSubApis(String oauthApiBaseUrl, String accessToken) {

		intentExtractionOperations = new IntentExtractionTemplate(oauthApiBaseUrl,
				getRestTemplate(), version);
		
		intentOperations = new IntentTemplate(oauthApiBaseUrl,
				getRestTemplate(), version);
		
		entityOperations = new EntityTemplate(oauthApiBaseUrl,
				getRestTemplate(), version);
	}

	// private helpers
	private void initialize(String apiBaseUrl, String accessToken) {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector
				.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis(apiBaseUrl, accessToken);

	}

	@Override
	public IntentExtractionOperations intentExtractionOperations() {
		return intentExtractionOperations;
	}
	
	@Override
	public IntentOperations intentOperations() {
		return intentOperations;
	}

	@Override
	public EntityOperations entityOperations() {
		return entityOperations;
	}

}
