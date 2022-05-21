package org.typesense.model;


import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class ImportDocumentsParameters extends BaseModel {

  @Schema()
  private String action = null;

  @Schema()
  private Integer batchSize = null;
  public enum DirtyValuesEnum {
    COERCE_OR_REJECT("coerce_or_reject"),
    COERCE_OR_DROP("coerce_or_drop"),
    DROP("drop"),
    REJECT("reject");

    private final String value;

    DirtyValuesEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static DirtyValuesEnum fromValue(String text) {
      for (DirtyValuesEnum b : DirtyValuesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @Schema()
  private DirtyValuesEnum dirtyValues = null;
 /**
   * Get action
   * @return action
  **/
  @JsonProperty("action")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public ImportDocumentsParameters action(String action) {
    this.action = action;
    return this;
  }

 /**
   * Get batchSize
   * @return batchSize
  **/
  @JsonProperty("batch_size")
  public Integer getBatchSize() {
    return batchSize;
  }

  public void setBatchSize(Integer batchSize) {
    this.batchSize = batchSize;
  }

  public ImportDocumentsParameters batchSize(Integer batchSize) {
    this.batchSize = batchSize;
    return this;
  }

 /**
   * Get dirtyValues
   * @return dirtyValues
  **/
  @JsonProperty("dirty_values")
  public String getDirtyValues() {
    if (dirtyValues == null) {
      return null;
    }
    return dirtyValues.getValue();
  }

  public void setDirtyValues(DirtyValuesEnum dirtyValues) {
    this.dirtyValues = dirtyValues;
  }

  public ImportDocumentsParameters dirtyValues(DirtyValuesEnum dirtyValues) {
    this.dirtyValues = dirtyValues;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportDocumentsParameters {\n");

    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    batchSize: ").append(toIndentedString(batchSize)).append("\n");
    sb.append("    dirtyValues: ").append(toIndentedString(dirtyValues)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
