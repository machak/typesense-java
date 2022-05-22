package org.typesense.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchResultHit extends BaseModel {

    @Schema(description = "Contains highlighted portions of the search fields")
    /**
     * Contains highlighted portions of the search fields
     **/
    private List<SearchHighlight> highlights = null;

    @Schema(description = "Can be any key-value pair")
    /**
     * Can be any key-value pair
     **/
    private Map<String, Object> document = null;

    @Schema()
    private Long textMatch = null;

    @Schema(description = "Can be any key-value pair")
    /**
     * Can be any key-value pair
     **/
    private Map<String, Integer> geoDistanceMeters = null;

    /**
     * Contains highlighted portions of the search fields
     *
     * @return highlights
     **/
    @JsonProperty("highlights")
    public List<SearchHighlight> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<SearchHighlight> highlights) {
        this.highlights = highlights;
    }

    public SearchResultHit highlights(List<SearchHighlight> highlights) {
        this.highlights = highlights;
        return this;
    }

    public SearchResultHit addHighlightsItem(SearchHighlight highlightsItem) {
        this.highlights.add(highlightsItem);
        return this;
    }

    /**
     * Can be any key-value pair
     *
     * @return document
     **/
    @JsonProperty("document")
    public Map<String, Object> getDocument() {
        return document;
    }

    public void setDocument(Map<String, Object> document) {
        this.document = document;
    }

    public SearchResultHit document(Map<String, Object> document) {
        this.document = document;
        return this;
    }

    public SearchResultHit putDocumentItem(String key, Object documentItem) {
        this.document.put(key, documentItem);
        return this;
    }

    /**
     * Get textMatch
     *
     * @return textMatch
     **/
    @JsonProperty("text_match")
    public Long getTextMatch() {
        return textMatch;
    }

    public void setTextMatch(Long textMatch) {
        this.textMatch = textMatch;
    }

    public SearchResultHit textMatch(Long textMatch) {
        this.textMatch = textMatch;
        return this;
    }

    /**
     * Can be any key-value pair
     *
     * @return geoDistanceMeters
     **/
    @JsonProperty("geo_distance_meters")
    public Map<String, Integer> getGeoDistanceMeters() {
        return geoDistanceMeters;
    }

    public void setGeoDistanceMeters(Map<String, Integer> geoDistanceMeters) {
        this.geoDistanceMeters = geoDistanceMeters;
    }

    public SearchResultHit geoDistanceMeters(Map<String, Integer> geoDistanceMeters) {
        this.geoDistanceMeters = geoDistanceMeters;
        return this;
    }

    public SearchResultHit putGeoDistanceMetersItem(String key, Integer geoDistanceMetersItem) {
        this.geoDistanceMeters.put(key, geoDistanceMetersItem);
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class SearchResultHit {\n" +
                "    highlights: " + toIndentedString(highlights) + '\n' +
                "    document: " + toIndentedString(document) + '\n' +
                "    textMatch: " + toIndentedString(textMatch) + '\n' +
                "    geoDistanceMeters: " + toIndentedString(geoDistanceMeters) + '\n' +
                '}';
        return sb;
    }

}
