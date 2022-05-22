package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class MultiSearchResult extends BaseModel {

    @Schema(required = true)
    private List<SearchResult> results = new ArrayList<SearchResult>();

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

    public MultiSearchResult results(List<SearchResult> results) {
        this.results = results;
        return this;
    }

    public MultiSearchResult addResultsItem(SearchResult resultsItem) {
        this.results.add(resultsItem);
        return this;
    }


    @Override
    public String toString() {

        return "class MultiSearchResult {\n" +
                "    results: " + toIndentedString(results) + '\n' +
                '}';
    }

}
