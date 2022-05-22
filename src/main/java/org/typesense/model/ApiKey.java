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
        final String sb = "class ApiKey {\n" +
                "    " + toIndentedString(super.toString()) + '\n' +
                "    id: " + toIndentedString(id) + '\n' +
                "    value: " + toIndentedString(value) + '\n' +
                "    valuePrefix: " + toIndentedString(valuePrefix) + '\n' +
                '}';
        return sb;
    }

}
