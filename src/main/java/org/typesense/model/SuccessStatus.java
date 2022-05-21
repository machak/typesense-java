package org.typesense.model;


import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessStatus extends BaseModel {

  @Schema(required = true)
  private Boolean success = null;
 /**
   * Get success
   * @return success
  **/
  @JsonProperty("success")
  public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public SuccessStatus success(Boolean success) {
    this.success = success;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessStatus {\n");

    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
