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
        final String sb = "class MultiSearchCollectionParameters {\n" +
                "    " + toIndentedString(super.toString()) + '\n' +
                "    collection: " + toIndentedString(collection) + '\n' +
                '}';
        return sb;
    }


}
