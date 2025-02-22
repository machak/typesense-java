package org.typesense.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchResult extends BaseModel {

    @Schema()
    private List<FacetCounts> facetCounts = null;

    @Schema(description = "The number of documents found")
    /**
     * The number of documents found
     **/
    private Integer found = null;

    @Schema(description = "The number of milliseconds the search took")
    /**
     * The number of milliseconds the search took
     **/
    private Integer searchTimeMs = null;

    @Schema(description = "The total number of pages")
    /**
     * The total number of pages
     **/
    private Integer outOf = null;

    @Schema(description = "Whether the search was cut off")
    /**
     * Whether the search was cut off
     **/
    private Boolean searchCutoff = null;

    @Schema(description = "The search result page number")
    /**
     * The search result page number
     **/
    private Integer page = null;

    @Schema()
    private List<SearchGroupedHit> groupedHits = null;

    @Schema(description = "The documents that matched the search query")
    /**
     * The documents that matched the search query
     **/
    private List<SearchResultHit> hits = null;

    @Schema()
    private SearchResultRequestParams requestParams = null;

    /**
     * Get facetCounts
     *
     * @return facetCounts
     **/
    @JsonProperty("facet_counts")
    public List<FacetCounts> getFacetCounts() {
        return facetCounts;
    }

    public void setFacetCounts(List<FacetCounts> facetCounts) {
        this.facetCounts = facetCounts;
    }

    public SearchResult facetCounts(List<FacetCounts> facetCounts) {
        this.facetCounts = facetCounts;
        return this;
    }

    public SearchResult addFacetCountsItem(FacetCounts facetCountsItem) {
        this.facetCounts.add(facetCountsItem);
        return this;
    }

    /**
     * The number of documents found
     *
     * @return found
     **/
    @JsonProperty("found")
    public Integer getFound() {
        return found;
    }

    public void setFound(Integer found) {
        this.found = found;
    }

    public SearchResult found(Integer found) {
        this.found = found;
        return this;
    }

    /**
     * The number of milliseconds the search took
     *
     * @return searchTimeMs
     **/
    @JsonProperty("search_time_ms")
    public Integer getSearchTimeMs() {
        return searchTimeMs;
    }

    public void setSearchTimeMs(Integer searchTimeMs) {
        this.searchTimeMs = searchTimeMs;
    }

    public SearchResult searchTimeMs(Integer searchTimeMs) {
        this.searchTimeMs = searchTimeMs;
        return this;
    }

    /**
     * The total number of pages
     *
     * @return outOf
     **/
    @JsonProperty("out_of")
    public Integer getOutOf() {
        return outOf;
    }

    public void setOutOf(Integer outOf) {
        this.outOf = outOf;
    }

    public SearchResult outOf(Integer outOf) {
        this.outOf = outOf;
        return this;
    }

    /**
     * Whether the search was cut off
     *
     * @return searchCutoff
     **/
    @JsonProperty("search_cutoff")
    public Boolean isSearchCutoff() {
        return searchCutoff;
    }

    public void setSearchCutoff(Boolean searchCutoff) {
        this.searchCutoff = searchCutoff;
    }

    public SearchResult searchCutoff(Boolean searchCutoff) {
        this.searchCutoff = searchCutoff;
        return this;
    }

    /**
     * The search result page number
     *
     * @return page
     **/
    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public SearchResult page(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Get groupedHits
     *
     * @return groupedHits
     **/
    @JsonProperty("grouped_hits")
    public List<SearchGroupedHit> getGroupedHits() {
        return groupedHits;
    }

    public void setGroupedHits(List<SearchGroupedHit> groupedHits) {
        this.groupedHits = groupedHits;
    }

    public SearchResult groupedHits(List<SearchGroupedHit> groupedHits) {
        this.groupedHits = groupedHits;
        return this;
    }

    public SearchResult addGroupedHitsItem(SearchGroupedHit groupedHitsItem) {
        this.groupedHits.add(groupedHitsItem);
        return this;
    }

    /**
     * The documents that matched the search query
     *
     * @return hits
     **/
    @JsonProperty("hits")
    public List<SearchResultHit> getHits() {
        return hits;
    }

    public void setHits(List<SearchResultHit> hits) {
        this.hits = hits;
    }

    public SearchResult hits(List<SearchResultHit> hits) {
        this.hits = hits;
        return this;
    }

    public SearchResult addHitsItem(SearchResultHit hitsItem) {
        this.hits.add(hitsItem);
        return this;
    }

    /**
     * Get requestParams
     *
     * @return requestParams
     **/
    @JsonProperty("request_params")
    public SearchResultRequestParams getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(SearchResultRequestParams requestParams) {
        this.requestParams = requestParams;
    }

    public SearchResult requestParams(SearchResultRequestParams requestParams) {
        this.requestParams = requestParams;
        return this;
    }


    @Override
    public String toString() {

        return "class SearchResult {\n" +
                "    facetCounts: " + toIndentedString(facetCounts) + '\n' +
                "    found: " + toIndentedString(found) + '\n' +
                "    searchTimeMs: " + toIndentedString(searchTimeMs) + '\n' +
                "    outOf: " + toIndentedString(outOf) + '\n' +
                "    searchCutoff: " + toIndentedString(searchCutoff) + '\n' +
                "    page: " + toIndentedString(page) + '\n' +
                "    groupedHits: " + toIndentedString(groupedHits) + '\n' +
                "    hits: " + toIndentedString(hits) + '\n' +
                "    requestParams: " + toIndentedString(requestParams) + '\n' +
                '}';
    }


}
