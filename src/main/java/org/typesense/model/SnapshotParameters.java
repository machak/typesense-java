package org.typesense.model;


import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SnapshotParameters extends BaseModel {

  @Schema()
  private String snapshotPath = null;
 /**
   * Get snapshotPath
   * @return snapshotPath
  **/
  @JsonProperty("snapshot_path")
  public String getSnapshotPath() {
    return snapshotPath;
  }

  public void setSnapshotPath(String snapshotPath) {
    this.snapshotPath = snapshotPath;
  }

  public SnapshotParameters snapshotPath(String snapshotPath) {
    this.snapshotPath = snapshotPath;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SnapshotParameters {\n");

    sb.append("    snapshotPath: ").append(toIndentedString(snapshotPath)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
