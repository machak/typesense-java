package org.typesense.model;


import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InlineResponse200 extends BaseModel {

  @Schema(required = true)
  private Integer numDeleted = null;
 /**
   * Get numDeleted
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
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");

    sb.append("    numDeleted: ").append(toIndentedString(numDeleted)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
