package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchOverrideExclude extends BaseModel {

    @Schema(required = true, description = "document id that should be excluded from the search results.")
    /**
     * document id that should be excluded from the search results.
     **/
    private String id = null;

    /**
     * document id that should be excluded from the search results.
     *
     * @return id
     **/
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SearchOverrideExclude id(String id) {
        this.id = id;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SearchOverrideExclude {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
