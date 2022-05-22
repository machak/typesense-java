package org.typesense.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchSynonym extends SearchSynonymSchema {

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
        return "class SearchSynonym {\n" +
                "    " + toIndentedString(super.toString()) + '\n' +
                "    id: " + toIndentedString(id) + '\n' +
                '}';
    }

}
