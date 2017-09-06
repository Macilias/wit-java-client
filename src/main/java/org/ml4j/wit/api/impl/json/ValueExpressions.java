package org.ml4j.wit.api.impl.json;

import java.util.List;

public class ValueExpressions {

    private List<String> expressions;

    private String value;

    public List<String> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<String> expressions) {
        this.expressions = expressions;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ValueExpressions [expressions=" + expressions + ", value=" + value + "]";
    }

}
