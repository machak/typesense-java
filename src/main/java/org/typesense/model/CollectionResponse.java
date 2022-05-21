package org.typesense.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class CollectionResponse extends CollectionSchema {

    @Schema(required = true, description = "Number of documents in the collection")
    /**
     * Number of documents in the collection
     **/
    private final Long numDocuments = null;

    @Schema(required = true, description = "Timestamp of when the collection was created")
    /**
     * Timestamp of when the collection was created
     **/
    private final Long createdAt = null;

    /**
     * Number of documents in the collection
     *
     * @return numDocuments
     **/
    @JsonProperty("num_documents")
    public Long getNumDocuments() {
        return numDocuments;
    }


    /**
     * Timestamp of when the collection was created
     *
     * @return createdAt
     **/
    @JsonProperty("created_at")
    public Long getCreatedAt() {
        return createdAt;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CollectionResponse {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    numDocuments: ").append(toIndentedString(numDocuments)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
