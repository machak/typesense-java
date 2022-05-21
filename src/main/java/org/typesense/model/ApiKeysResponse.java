package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiKeysResponse extends BaseModel {

  @Schema(required = true)
  private List<ApiKey> keys = new ArrayList<ApiKey>();
 /**
   * Get keys
   * @return keys
  **/
  @JsonProperty("keys")
  public List<ApiKey> getKeys() {
    return keys;
  }

  public void setKeys(List<ApiKey> keys) {
    this.keys = keys;
  }

  public ApiKeysResponse keys(List<ApiKey> keys) {
    this.keys = keys;
    return this;
  }

  public ApiKeysResponse addKeysItem(ApiKey keysItem) {
    this.keys.add(keysItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiKeysResponse {\n");

    sb.append("    keys: ").append(toIndentedString(keys)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
