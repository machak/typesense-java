package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class CollectionAliasSchema extends BaseModel {

    @Schema(required = true, description = "Name of the collection you wish to map the alias to")
    /**
     * Name of the collection you wish to map the alias to
     **/
    private String collectionName = null;

    /**
     * Name of the collection you wish to map the alias to
     *
     * @return collectionName
     **/
    @JsonProperty("collection_name")
    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public CollectionAliasSchema collectionName(String collectionName) {
        this.collectionName = collectionName;
        return this;
    }


    @Override
    public String toString() {

        return "class CollectionAliasSchema {\n" +
                "    collectionName: " + toIndentedString(collectionName) + '\n' +
                '}';
    }

}
