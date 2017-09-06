package org.ml4j.wit.api;

import java.util.List;

import org.ml4j.wit.api.impl.json.EntityCreationRequest;
import org.ml4j.wit.api.impl.json.EntityResponse;
import org.ml4j.wit.api.impl.json.EntityUpdateRequest;
import org.ml4j.wit.api.impl.json.ValueCreationRequest;

public interface EntityOperations {

    public List<String> getEntityNames();

    public EntityResponse getEntityByNameOrId(String entityNameOrId);

    public EntityResponse createEntity(EntityCreationRequest entityCreationRequest);

    public void updateEntity(String entityId, EntityUpdateRequest entityUpdateRequest);

    public void createEntityValue(String entityId, ValueCreationRequest request);

    public void deleteEntityValue(String entiyId, String value);

    public void addEntityExpression(String entityId, String entityValue, String expressionValue);

    public void deleteEntityExpression(String entityId, String entityValue, String expressionValue);

}
