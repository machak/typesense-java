package org.typesense.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchHighlight extends BaseModel {

    @Schema(example = "company_name")
    private String field = null;

    @Schema(example = "<mark>Stark</mark> Industries", description = "Present only for (non-array) string fields")
    /**
     * Present only for (non-array) string fields
     **/
    private String snippet = null;

    @Schema(example = "[\"<mark>Stark</mark> Industries\",\"<mark>Stark</mark> Corp\"]", description = "Present only for (array) string[] fields")
    /**
     * Present only for (array) string[] fields
     **/
    private List<String> snippets = null;

    @Schema(example = "1", description = "The indices property will be present only for string[] fields and will contain the corresponding indices of the snippets in the search field")
    /**
     * The indices property will be present only for string[] fields and will contain the corresponding indices of the snippets in the search field
     **/
    private List<Integer> indices = null;

    @Schema()
    private List<Object> matchedTokens = null;

    /**
     * Get field
     *
     * @return field
     **/
    @JsonProperty("field")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public SearchHighlight field(String field) {
        this.field = field;
        return this;
    }

    /**
     * Present only for (non-array) string fields
     *
     * @return snippet
     **/
    @JsonProperty("snippet")
    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public SearchHighlight snippet(String snippet) {
        this.snippet = snippet;
        return this;
    }

    /**
     * Present only for (array) string[] fields
     *
     * @return snippets
     **/
    @JsonProperty("snippets")
    public List<String> getSnippets() {
        return snippets;
    }

    public void setSnippets(List<String> snippets) {
        this.snippets = snippets;
    }

    public SearchHighlight snippets(List<String> snippets) {
        this.snippets = snippets;
        return this;
    }

    public SearchHighlight addSnippetsItem(String snippetsItem) {
        this.snippets.add(snippetsItem);
        return this;
    }

    /**
     * The indices property will be present only for string[] fields and will contain the corresponding indices of the snippets in the search field
     *
     * @return indices
     **/
    @JsonProperty("indices")
    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public SearchHighlight indices(List<Integer> indices) {
        this.indices = indices;
        return this;
    }

    public SearchHighlight addIndicesItem(Integer indicesItem) {
        this.indices.add(indicesItem);
        return this;
    }

    /**
     * Get matchedTokens
     *
     * @return matchedTokens
     **/
    @JsonProperty("matched_tokens")
    public List<Object> getMatchedTokens() {
        return matchedTokens;
    }

    public void setMatchedTokens(List<Object> matchedTokens) {
        this.matchedTokens = matchedTokens;
    }

    public SearchHighlight matchedTokens(List<Object> matchedTokens) {
        this.matchedTokens = matchedTokens;
        return this;
    }

    public SearchHighlight addMatchedTokensItem(Object matchedTokensItem) {
        this.matchedTokens.add(matchedTokensItem);
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class SearchHighlight {\n" +
                "    field: " + toIndentedString(field) + '\n' +
                "    snippet: " + toIndentedString(snippet) + '\n' +
                "    snippets: " + toIndentedString(snippets) + '\n' +
                "    indices: " + toIndentedString(indices) + '\n' +
                "    matchedTokens: " + toIndentedString(matchedTokens) + '\n' +
                '}';
        return sb;
    }

}
