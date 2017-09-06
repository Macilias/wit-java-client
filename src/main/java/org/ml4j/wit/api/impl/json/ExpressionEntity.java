package org.ml4j.wit.api.impl.json;

public class ExpressionEntity {

    private String wisp;
    private String value;
    private Integer start;
    private Integer end;

    public String getWisp() {
        return wisp;
    }

    public void setWisp(String wisp) {
        this.wisp = wisp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "ExpressionEntity [wisp=" + wisp + ", value=" + value + ", start=" + start + ", end=" + end + "]";
    }

}
