package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class InlineResponse200 extends BaseModel {

    @Schema(required = true)
    private Integer numDeleted = null;

    /**
     * Get numDeleted
     *
     * @return numDeleted
     **/
    @JsonProperty("num_deleted")
    public Integer getNumDeleted() {
        return numDeleted;
    }

    public void setNumDeleted(Integer numDeleted) {
        this.numDeleted = numDeleted;
    }

    public InlineResponse200 numDeleted(Integer numDeleted) {
        this.numDeleted = numDeleted;
        return this;
    }


    @Override
    public String toString() {

        return "class InlineResponse200 {\n" +
                "    numDeleted: " + toIndentedString(numDeleted) + '\n' +
                '}';
    }

}
