package org.typesense.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class FacetCounts extends BaseModel {

    @Schema()
    private List<FacetCountsCounts> counts = null;

    @Schema()
    private String fieldName = null;

    @Schema()
    private FacetCountsStats stats = null;

    /**
     * Get counts
     *
     * @return counts
     **/
    @JsonProperty("counts")
    public List<FacetCountsCounts> getCounts() {
        return counts;
    }

    public void setCounts(List<FacetCountsCounts> counts) {
        this.counts = counts;
    }

    public FacetCounts counts(List<FacetCountsCounts> counts) {
        this.counts = counts;
        return this;
    }

    public FacetCounts addCountsItem(FacetCountsCounts countsItem) {
        this.counts.add(countsItem);
        return this;
    }

    /**
     * Get fieldName
     *
     * @return fieldName
     **/
    @JsonProperty("field_name")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public FacetCounts fieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    /**
     * Get stats
     *
     * @return stats
     **/
    @JsonProperty("stats")
    public FacetCountsStats getStats() {
        return stats;
    }

    public void setStats(FacetCountsStats stats) {
        this.stats = stats;
    }

    public FacetCounts stats(FacetCountsStats stats) {
        this.stats = stats;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FacetCounts {\n");

        sb.append("    counts: ").append(toIndentedString(counts)).append("\n");
        sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
        sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
