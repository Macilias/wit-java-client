package org.ml4j.wit.api.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpressionValue {

    @JsonProperty("expression")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ExpressionValue() {
    }

    public ExpressionValue(String value) {
        this.value = value;
    }

}
