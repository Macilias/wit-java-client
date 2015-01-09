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

import org.springframework.web.client.RestTemplate;

/**
 * @author Michael Lavelle
 */
public abstract class AbstractWitOperations {

	protected final RestTemplate restTemplate;
	private String apiBaseUrl;
	protected String version;

	public AbstractWitOperations(String apiBaseUrl, RestTemplate restTemplate,
			String version) {
		this.restTemplate = restTemplate;
		this.apiBaseUrl = apiBaseUrl;
		this.version = version;
	}

	protected String getApiBaseUrl() {
		return apiBaseUrl;
	}

}
