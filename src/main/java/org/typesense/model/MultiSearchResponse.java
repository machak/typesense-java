package org.typesense.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class MultiSearchResponse extends BaseModel {

    @Schema()
    private List<SearchResult> results = null;

    /**
     * Get results
     *
     * @return results
     **/
    @JsonProperty("results")
    public List<SearchResult> getResults() {
        return results;
    }

    public void setResults(List<SearchResult> results) {
        this.results = results;
    }

    public MultiSearchResponse results(List<SearchResult> results) {
        this.results = results;
        return this;
    }

    public MultiSearchResponse addResultsItem(SearchResult resultsItem) {
        this.results.add(resultsItem);
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MultiSearchResponse {\n");

        sb.append("    results: ").append(toIndentedString(results)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
