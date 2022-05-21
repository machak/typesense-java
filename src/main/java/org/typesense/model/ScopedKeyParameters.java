package org.typesense.model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScopedKeyParameters extends BaseModel {

  @Schema()
  private String filterBy = null;

  @Schema()
  private BigDecimal expiresAt = null;
 /**
   * Get filterBy
   * @return filterBy
  **/
  @JsonProperty("filter_by")
  public String getFilterBy() {
    return filterBy;
  }

  public void setFilterBy(String filterBy) {
    this.filterBy = filterBy;
  }

  public ScopedKeyParameters filterBy(String filterBy) {
    this.filterBy = filterBy;
    return this;
  }

 /**
   * Get expiresAt
   * @return expiresAt
  **/
  @JsonProperty("expires_at")
  public BigDecimal getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(BigDecimal expiresAt) {
    this.expiresAt = expiresAt;
  }

  public ScopedKeyParameters expiresAt(BigDecimal expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScopedKeyParameters {\n");

    sb.append("    filterBy: ").append(toIndentedString(filterBy)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }


}
