package org.typesense.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchOverride extends SearchOverrideSchema {

    @Schema(required = true)
    private final String id = null;

    /**
     * Get id
     *
     * @return id
     **/
    @JsonProperty("id")
    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        final String sb = "class SearchOverride {\n" +
                "    " + toIndentedString(super.toString()) + '\n' +
                "    id: " + toIndentedString(id) + '\n' +
                '}';
        return sb;
    }

}
