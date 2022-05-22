package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class FacetCountsCounts extends BaseModel {

    @Schema()
    private Integer count = null;

    @Schema()
    private String highlighted = null;

    @Schema()
    private String value = null;

    /**
     * Get count
     *
     * @return count
     **/
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public FacetCountsCounts count(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Get highlighted
     *
     * @return highlighted
     **/
    @JsonProperty("highlighted")
    public String getHighlighted() {
        return highlighted;
    }

    public void setHighlighted(String highlighted) {
        this.highlighted = highlighted;
    }

    public FacetCountsCounts highlighted(String highlighted) {
        this.highlighted = highlighted;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FacetCountsCounts value(String value) {
        this.value = value;
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class FacetCountsCounts {\n" +
                "    count: " + toIndentedString(count) + '\n' +
                "    highlighted: " + toIndentedString(highlighted) + '\n' +
                "    value: " + toIndentedString(value) + '\n' +
                '}';
        return sb;
    }

}
