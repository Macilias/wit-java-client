package org.ml4j.wit.api;

import org.ml4j.wit.api.impl.json.IntentListResponse;
import org.ml4j.wit.api.impl.json.IntentResponse;

public interface IntentOperations {

    public IntentResponse getIntentByNameOrId(String intentName);

    public IntentListResponse getIntents();

}
