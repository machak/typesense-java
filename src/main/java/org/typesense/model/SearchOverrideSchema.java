package org.typesense.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchOverrideSchema extends BaseModel {

    @Schema(required = true)
    private SearchOverrideRule rule = null;

    @Schema(description = "List of document `id`s that should be included in the search results with their corresponding `position`s.")
    /**
     * List of document `id`s that should be included in the search results with their corresponding `position`s.
     **/
    private List<SearchOverrideInclude> includes = null;

    @Schema(description = "List of document `id`s that should be excluded from the search results.")
    /**
     * List of document `id`s that should be excluded from the search results.
     **/
    private List<SearchOverrideExclude> excludes = null;

    @Schema(description = "A filter by clause that is applied to any search query that matches the override rule. ")
    /**
     * A filter by clause that is applied to any search query that matches the override rule.
     **/
    private String filterBy = null;

    @Schema(description = "Indicates whether search query tokens that exist in the override's rule should be removed from the search query. ")
    /**
     * Indicates whether search query tokens that exist in the override's rule should be removed from the search query.
     **/
    private Boolean removeMatchedTokens = null;

    /**
     * Get rule
     *
     * @return rule
     **/
    @JsonProperty("rule")
    public SearchOverrideRule getRule() {
        return rule;
    }

    public void setRule(SearchOverrideRule rule) {
        this.rule = rule;
    }

    public SearchOverrideSchema rule(SearchOverrideRule rule) {
        this.rule = rule;
        return this;
    }

    /**
     * List of document &#x60;id&#x60;s that should be included in the search results with their corresponding &#x60;position&#x60;s.
     *
     * @return includes
     **/
    @JsonProperty("includes")
    public List<SearchOverrideInclude> getIncludes() {
        return includes;
    }

    public void setIncludes(List<SearchOverrideInclude> includes) {
        this.includes = includes;
    }

    public SearchOverrideSchema includes(List<SearchOverrideInclude> includes) {
        this.includes = includes;
        return this;
    }

    public SearchOverrideSchema addIncludesItem(SearchOverrideInclude includesItem) {
        this.includes.add(includesItem);
        return this;
    }

    /**
     * List of document &#x60;id&#x60;s that should be excluded from the search results.
     *
     * @return excludes
     **/
    @JsonProperty("excludes")
    public List<SearchOverrideExclude> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<SearchOverrideExclude> excludes) {
        this.excludes = excludes;
    }

    public SearchOverrideSchema excludes(List<SearchOverrideExclude> excludes) {
        this.excludes = excludes;
        return this;
    }

    public SearchOverrideSchema addExcludesItem(SearchOverrideExclude excludesItem) {
        this.excludes.add(excludesItem);
        return this;
    }

    /**
     * A filter by clause that is applied to any search query that matches the override rule.
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

    public SearchOverrideSchema filterBy(String filterBy) {
        this.filterBy = filterBy;
        return this;
    }

    /**
     * Indicates whether search query tokens that exist in the override&#x27;s rule should be removed from the search query.
     *
     * @return removeMatchedTokens
     **/
    @JsonProperty("remove_matched_tokens")
    public Boolean isRemoveMatchedTokens() {
        return removeMatchedTokens;
    }

    public void setRemoveMatchedTokens(Boolean removeMatchedTokens) {
        this.removeMatchedTokens = removeMatchedTokens;
    }

    public SearchOverrideSchema removeMatchedTokens(Boolean removeMatchedTokens) {
        this.removeMatchedTokens = removeMatchedTokens;
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class SearchOverrideSchema {\n" +
                "    rule: " + toIndentedString(rule) + '\n' +
                "    includes: " + toIndentedString(includes) + '\n' +
                "    excludes: " + toIndentedString(excludes) + '\n' +
                "    filterBy: " + toIndentedString(filterBy) + '\n' +
                "    removeMatchedTokens: " + toIndentedString(removeMatchedTokens) + '\n' +
                '}';
        return sb;
    }

}
