package org.ml4j.wit.api.impl.json;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.springframework.web.util.UriUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
public class Context {

    private String[] state;

    @JsonProperty("reference_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date referenceTime;

    private String timezone;

    @JsonProperty("entities")
    private List<EntityCreationRequest> entityCreationRequests;

    public String toEncodedParameterValue() {
        try {
            String json = new ObjectMapper().writeValueAsString(this);
            System.out.println(json);
            String encoded = UriUtils.encodeQueryParam(json, "UTF-8").replaceAll("\\:", "%3A").replaceAll("\\,", "%2C");
            return encoded;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] getState() {
        return state;
    }

    public void setState(String[] state) {
        this.state = state;
    }

    public Date getReferenceTime() {
        return referenceTime;
    }

    public void setReferenceTime(Date referenceTime) {
        this.referenceTime = referenceTime;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<EntityCreationRequest> getEntityCreationRequests() {
        return entityCreationRequests;
    }

    public void setEntityCreationRequests(List<EntityCreationRequest> entityCreationRequests) {
        this.entityCreationRequests = entityCreationRequests;
    }


}
