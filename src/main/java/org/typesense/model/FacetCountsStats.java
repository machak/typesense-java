package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class FacetCountsStats extends BaseModel {

    @Schema()
    private Integer max = null;

    @Schema()
    private Integer min = null;

    @Schema()
    private Integer sum = null;

    @Schema()
    private Integer totalValues = null;

    @Schema()
    private Float avg = null;

    /**
     * Get max
     *
     * @return max
     **/
    @JsonProperty("max")
    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public FacetCountsStats max(Integer max) {
        this.max = max;
        return this;
    }

    /**
     * Get min
     *
     * @return min
     **/
    @JsonProperty("min")
    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public FacetCountsStats min(Integer min) {
        this.min = min;
        return this;
    }

    /**
     * Get sum
     *
     * @return sum
     **/
    @JsonProperty("sum")
    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public FacetCountsStats sum(Integer sum) {
        this.sum = sum;
        return this;
    }

    /**
     * Get totalValues
     *
     * @return totalValues
     **/
    @JsonProperty("total_values")
    public Integer getTotalValues() {
        return totalValues;
    }

    public void setTotalValues(Integer totalValues) {
        this.totalValues = totalValues;
    }

    public FacetCountsStats totalValues(Integer totalValues) {
        this.totalValues = totalValues;
        return this;
    }

    /**
     * Get avg
     *
     * @return avg
     **/
    @JsonProperty("avg")
    public Float getAvg() {
        return avg;
    }

    public void setAvg(Float avg) {
        this.avg = avg;
    }

    public FacetCountsStats avg(Float avg) {
        this.avg = avg;
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class FacetCountsStats {\n" +
                "    max: " + toIndentedString(max) + '\n' +
                "    min: " + toIndentedString(min) + '\n' +
                "    sum: " + toIndentedString(sum) + '\n' +
                "    totalValues: " + toIndentedString(totalValues) + '\n' +
                "    avg: " + toIndentedString(avg) + '\n' +
                '}';
        return sb;
    }

}
