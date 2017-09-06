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

import org.ml4j.wit.api.IntentOperations;
import org.ml4j.wit.api.impl.json.IntentListResponse;
import org.ml4j.wit.api.impl.json.IntentResponse;
import org.springframework.web.client.RestTemplate;

/**
 * @author Michael Lavelle
 */
public class IntentTemplate extends AbstractWitResourceOperations implements IntentOperations {

    public IntentTemplate(String oauthApiBaseUrl, RestTemplate restTemplate, String version) {
        super(oauthApiBaseUrl, restTemplate, version);
    }

    @Override
    protected String getApiResourceBaseUrl() {
        return getApiBaseUrl();
    }

    @Override
    public IntentResponse getIntentByNameOrId(String name) {
        return restTemplate.getForObject(getApiResourceUrl("/intents/" + name), IntentResponse.class);
    }

    @Override
    public IntentListResponse getIntents() {
        return restTemplate.getForObject(getApiResourceUrl("/intents"), IntentListResponse.class);
    }

}
