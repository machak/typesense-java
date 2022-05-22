package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SnapshotParameters extends BaseModel {

    @Schema()
    private String snapshotPath = null;

    /**
     * Get snapshotPath
     *
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

        return "class SnapshotParameters {\n" +
                "    snapshotPath: " + toIndentedString(snapshotPath) + '\n' +
                '}';
    }

}
