package org.typesense.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class ApiKey extends ApiKeySchema {

    @Schema(required = true)
    private final Long id = null;

    @Schema(required = true)
    private final String value = null;

    @Schema(required = true)
    private final String valuePrefix = null;

    /**
     * Get id
     *
     * @return id
     **/
    @JsonProperty("id")
    public Long getId() {
        return id;
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


    /**
     * Get valuePrefix
     *
     * @return valuePrefix
     **/
    @JsonProperty("value_prefix")
    public String getValuePrefix() {
        return valuePrefix;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiKey {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    valuePrefix: ").append(toIndentedString(valuePrefix)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
