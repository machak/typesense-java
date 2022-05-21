package org.typesense.model;


import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CollectionAlias extends BaseModel {

  @Schema(required = true, description = "Name of the collection alias")
 /**
   * Name of the collection alias
  **/
  private final String name = null;

  @Schema(required = true, description = "Name of the collection the alias mapped to")
 /**
   * Name of the collection the alias mapped to
  **/
  private String collectionName = null;
 /**
   * Name of the collection alias
   * @return name
  **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }


 /**
   * Name of the collection the alias mapped to
   * @return collectionName
  **/
  @JsonProperty("collection_name")
  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  public CollectionAlias collectionName(String collectionName) {
    this.collectionName = collectionName;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectionAlias {\n");

    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    collectionName: ").append(toIndentedString(collectionName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
