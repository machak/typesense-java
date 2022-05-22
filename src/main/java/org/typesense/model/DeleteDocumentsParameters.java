package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class DeleteDocumentsParameters extends BaseModel {

    @Schema(example = "num_employees:>100 && country: [USA, UK]")
    private String filterBy = null;

    @Schema(description = "Batch size parameter controls the number of documents that should be deleted at a time. A larger value will speed up deletions, but will impact performance of other operations running on the server.")
    /**
     * Batch size parameter controls the number of documents that should be deleted at a time. A larger value will speed up deletions, but will impact performance of other operations running on the server.
     **/
    private Integer batchSize = null;

    /**
     * Get filterBy
     *
     * @return filterBy
     **/
    @JsonProperty("filter_by")
    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public DeleteDocumentsParameters filterBy(String filterBy) {
        this.filterBy = filterBy;
        return this;
    }

    /**
     * Batch size parameter controls the number of documents that should be deleted at a time. A larger value will speed up deletions, but will impact performance of other operations running on the server.
     *
     * @return batchSize
     **/
    @JsonProperty("batch_size")
    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public DeleteDocumentsParameters batchSize(Integer batchSize) {
        this.batchSize = batchSize;
        return this;
    }


    @Override
    public String toString() {

        return "class DeleteDocumentsParameters {\n" +
                "    filterBy: " + toIndentedString(filterBy) + '\n' +
                "    batchSize: " + toIndentedString(batchSize) + '\n' +
                '}';
    }


}
