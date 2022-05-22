package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchOverrideInclude extends BaseModel {

    @Schema(required = true, description = "document id that should be included")
    /**
     * document id that should be included
     **/
    private String id = null;

    @Schema(required = true, description = "position number where document should be included in the search results")
    /**
     * position number where document should be included in the search results
     **/
    private Integer position = null;

    /**
     * document id that should be included
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

    public SearchOverrideInclude id(String id) {
        this.id = id;
        return this;
    }

    /**
     * position number where document should be included in the search results
     *
     * @return position
     **/
    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public SearchOverrideInclude position(Integer position) {
        this.position = position;
        return this;
    }


    @Override
    public String toString() {

        return "class SearchOverrideInclude {\n" +
                "    id: " + toIndentedString(id) + '\n' +
                "    position: " + toIndentedString(position) + '\n' +
                '}';
    }

}
