package org.typesense.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class MultiSearchCollectionParameters extends MultiSearchParameters {

    @Schema(required = true, description = "The collection to search in. ")
    /**
     * The collection to search in.
     **/
    private String collection = null;

    /**
     * The collection to search in.
     *
     * @return collection
     **/
    @JsonProperty("collection")
    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public MultiSearchCollectionParameters collection(String collection) {
        this.collection = collection;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MultiSearchCollectionParameters {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    collection: ").append(toIndentedString(collection)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}
