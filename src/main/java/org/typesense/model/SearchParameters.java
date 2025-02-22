package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchParameters extends BaseModel {

    @Schema(required = true, description = "The query text to search for in the collection. Use * as the search string to return all documents. This is typically useful when used in conjunction with filter_by.")
    /**
     * The query text to search for in the collection. Use * as the search string to return all documents. This is typically useful when used in conjunction with filter_by.
     **/
    private String q = null;

    @Schema(required = true, description = "A list of `string` fields that should be queried against. Multiple fields are separated with a comma.")
    /**
     * A list of `string` fields that should be queried against. Multiple fields are separated with a comma.
     **/
    private String queryBy = null;

    @Schema(description = "The relative weight to give each `query_by` field when ranking results. This can be used to boost fields in priority, when looking for matches. Multiple fields are separated with a comma.")
    /**
     * The relative weight to give each `query_by` field when ranking results. This can be used to boost fields in priority, when looking for matches. Multiple fields are separated with a comma.
     **/
    private String queryByWeights = null;

    @Schema(description = "Boolean field to indicate that the last word in the query should be treated as a prefix, and not as a whole word. This is used for building autocomplete and instant search interfaces. Defaults to true.")
    /**
     * Boolean field to indicate that the last word in the query should be treated as a prefix, and not as a whole word. This is used for building autocomplete and instant search interfaces. Defaults to true.
     **/
    private String prefix = null;

    @Schema(example = "num_employees:>100 && country: [USA, UK]", description = "Filter conditions for refining youropen api validator search results. Separate multiple conditions with &&.")
    /**
     * Filter conditions for refining youropen api validator search results. Separate multiple conditions with &&.
     **/
    private String filterBy = null;

    @Schema(example = "num_employees:desc", description = "A list of numerical fields and their corresponding sort orders that will be used for ordering your results. Up to 3 sort fields can be specified. The text similarity score is exposed as a special `_text_match` field that you can use in the list of sorting fields. If no `sort_by` parameter is specified, results are sorted by `_text_match:desc,default_sorting_field:desc`")
    /**
     * A list of numerical fields and their corresponding sort orders that will be used for ordering your results. Up to 3 sort fields can be specified. The text similarity score is exposed as a special `_text_match` field that you can use in the list of sorting fields. If no `sort_by` parameter is specified, results are sorted by `_text_match:desc,default_sorting_field:desc`
     **/
    private String sortBy = null;

    @Schema(description = "A list of fields that will be used for faceting your results on. Separate multiple fields with a comma.")
    /**
     * A list of fields that will be used for faceting your results on. Separate multiple fields with a comma.
     **/
    private String facetBy = null;

    @Schema(description = "Maximum number of facet values to be returned.")
    /**
     * Maximum number of facet values to be returned.
     **/
    private Integer maxFacetValues = null;

    @Schema(description = "Facet values that are returned can now be filtered via this parameter. The matching facet text is also highlighted. For example, when faceting by `category`, you can set `facet_query=category:shoe` to return only facet values that contain the prefix \"shoe\".")
    /**
     * Facet values that are returned can now be filtered via this parameter. The matching facet text is also highlighted. For example, when faceting by `category`, you can set `facet_query=category:shoe` to return only facet values that contain the prefix \"shoe\".
     **/
    private String facetQuery = null;

    @Schema(description = "The number of typographical errors (1 or 2) that would be tolerated. Default: 2 ")
    /**
     * The number of typographical errors (1 or 2) that would be tolerated. Default: 2
     **/
    private Integer numTypos = null;

    @Schema(description = "Results from this specific page number would be fetched.")
    /**
     * Results from this specific page number would be fetched.
     **/
    private Integer page = null;

    @Schema(description = "Number of results to fetch per page. Default: 10")
    /**
     * Number of results to fetch per page. Default: 10
     **/
    private Integer perPage = null;

    @Schema(description = "You can aggregate search results into groups or buckets by specify one or more `group_by` fields. Separate multiple fields with a comma. To group on a particular field, it must be a faceted field.")
    /**
     * You can aggregate search results into groups or buckets by specify one or more `group_by` fields. Separate multiple fields with a comma. To group on a particular field, it must be a faceted field.
     **/
    private String groupBy = null;

    @Schema(description = "Maximum number of hits to be returned for every group. If the `group_limit` is set as `K` then only the top K hits in each group are returned in the response. Default: 3 ")
    /**
     * Maximum number of hits to be returned for every group. If the `group_limit` is set as `K` then only the top K hits in each group are returned in the response. Default: 3
     **/
    private Integer groupLimit = null;

    @Schema(description = "List of fields from the document to include in the search result")
    /**
     * List of fields from the document to include in the search result
     **/
    private String includeFields = null;

    @Schema(description = "List of fields from the document to exclude in the search result")
    /**
     * List of fields from the document to exclude in the search result
     **/
    private String excludeFields = null;

    @Schema(description = "List of fields which should be highlighted fully without snippeting")
    /**
     * List of fields which should be highlighted fully without snippeting
     **/
    private String highlightFullFields = null;

    @Schema(description = "The number of tokens that should surround the highlighted text on each side. Default: 4 ")
    /**
     * The number of tokens that should surround the highlighted text on each side. Default: 4
     **/
    private Integer highlightAffixNumTokens = null;

    @Schema(description = "The start tag used for the highlighted snippets. Default: `<mark>` ")
    /**
     * The start tag used for the highlighted snippets. Default: `<mark>`
     **/
    private String highlightStartTag = null;

    @Schema(description = "The end tag used for the highlighted snippets. Default: `</mark>` ")
    /**
     * The end tag used for the highlighted snippets. Default: `</mark>`
     **/
    private String highlightEndTag = null;

    @Schema(description = "Field values under this length will be fully highlighted, instead of showing a snippet of relevant portion. Default: 30 ")
    /**
     * Field values under this length will be fully highlighted, instead of showing a snippet of relevant portion. Default: 30
     **/
    private Integer snippetThreshold = null;

    @Schema(description = "If the number of results found for a specific query is less than this number, Typesense will attempt to drop the tokens in the query until enough results are found. Tokens that have the least individual hits are dropped first. Set to 0 to disable. Default: 10 ")
    /**
     * If the number of results found for a specific query is less than this number, Typesense will attempt to drop the tokens in the query until enough results are found. Tokens that have the least individual hits are dropped first. Set to 0 to disable. Default: 10
     **/
    private Integer dropTokensThreshold = null;

    @Schema(description = "If the number of results found for a specific query is less than this number, Typesense will attempt to look for tokens with more typos until enough results are found. Default: 100 ")
    /**
     * If the number of results found for a specific query is less than this number, Typesense will attempt to look for tokens with more typos until enough results are found. Default: 100
     **/
    private Integer typoTokensThreshold = null;

    @Schema(description = "A list of records to unconditionally include in the search results at specific positions. An example use case would be to feature or promote certain items on the top of search results. A list of `record_id:hit_position`. Eg: to include a record with ID 123 at Position 1 and another record with ID 456 at Position 5, you'd specify `123:1,456:5`. You could also use the Overrides feature to override search results based on rules. Overrides are applied first, followed by `pinned_hits` and  finally `hidden_hits`. ")
    /**
     * A list of records to unconditionally include in the search results at specific positions. An example use case would be to feature or promote certain items on the top of search results. A list of `record_id:hit_position`. Eg: to include a record with ID 123 at Position 1 and another record with ID 456 at Position 5, you'd specify `123:1,456:5`. You could also use the Overrides feature to override search results based on rules. Overrides are applied first, followed by `pinned_hits` and  finally `hidden_hits`.
     **/
    private String pinnedHits = null;

    @Schema(description = "A list of records to unconditionally hide from search results. A list of `record_id`s to hide. Eg: to hide records with IDs 123 and 456, you'd specify `123,456`. You could also use the Overrides feature to override search results based on rules. Overrides are applied first, followed by `pinned_hits` and finally `hidden_hits`. ")
    /**
     * A list of records to unconditionally hide from search results. A list of `record_id`s to hide. Eg: to hide records with IDs 123 and 456, you'd specify `123,456`. You could also use the Overrides feature to override search results based on rules. Overrides are applied first, followed by `pinned_hits` and finally `hidden_hits`.
     **/
    private String hiddenHits = null;

    @Schema(description = "A list of custom fields that must be highlighted even if you don't query  for them ")
    /**
     * A list of custom fields that must be highlighted even if you don't query  for them
     **/
    private String highlightFields = null;

    @Schema(description = "You can index content from any logographic language into Typesense if you are able to segment / split the text into space-separated words yourself  before indexing and querying. Set this parameter to true to do the same ")
    /**
     * You can index content from any logographic language into Typesense if you are able to segment / split the text into space-separated words yourself  before indexing and querying. Set this parameter to true to do the same
     **/
    private Boolean preSegmentedQuery = null;

    @Schema(description = "If you have some overrides defined but want to disable all of them during query time, you can do that by setting this parameter to false ")
    /**
     * If you have some overrides defined but want to disable all of them during query time, you can do that by setting this parameter to false
     **/
    private Boolean enableOverrides = null;

    @Schema(description = "Set this parameter to true to ensure that an exact match is ranked above the others ")
    /**
     * Set this parameter to true to ensure that an exact match is ranked above the others
     **/
    private Boolean prioritizeExactMatch = null;

    @Schema(description = "Setting this to true will make Typesense consider all prefixes and typo  corrections of the words in the query without stopping early when enough results are found  (drop_tokens_threshold and typo_tokens_threshold configurations are ignored). ")
    /**
     * Setting this to true will make Typesense consider all prefixes and typo  corrections of the words in the query without stopping early when enough results are found  (drop_tokens_threshold and typo_tokens_threshold configurations are ignored).
     **/
    private Boolean exhaustiveSearch = null;

    @Schema(description = "Typesense will attempt to return results early if the cutoff time has elapsed.  This is not a strict guarantee and facet computation is not bound by this parameter. ")
    /**
     * Typesense will attempt to return results early if the cutoff time has elapsed.  This is not a strict guarantee and facet computation is not bound by this parameter.
     **/
    private Integer searchCutoffMs = null;

    @Schema(description = "Enable server side caching of search query results. By default, caching is disabled. ")
    /**
     * Enable server side caching of search query results. By default, caching is disabled.
     **/
    private Boolean useCache = null;

    @Schema(description = "The duration (in seconds) that determines how long the search query is cached.  This value can be set on a per-query basis. Default: 60. ")
    /**
     * The duration (in seconds) that determines how long the search query is cached.  This value can be set on a per-query basis. Default: 60.
     **/
    private Integer cacheTtl = null;

    @Schema(description = "Minimum word length for 1-typo correction to be applied.  The value of num_typos is still treated as the maximum allowed typos. ")
    /**
     * Minimum word length for 1-typo correction to be applied.  The value of num_typos is still treated as the maximum allowed typos.
     **/
    private Integer minLen1typo = null;

    @Schema(description = "Minimum word length for 2-typo correction to be applied.  The value of num_typos is still treated as the maximum allowed typos. ")
    /**
     * Minimum word length for 2-typo correction to be applied.  The value of num_typos is still treated as the maximum allowed typos.
     **/
    private Integer minLen2typo = null;

    /**
     * The query text to search for in the collection. Use * as the search string to return all documents. This is typically useful when used in conjunction with filter_by.
     *
     * @return q
     **/
    @JsonProperty("q")
    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public SearchParameters q(String q) {
        this.q = q;
        return this;
    }

    /**
     * A list of &#x60;string&#x60; fields that should be queried against. Multiple fields are separated with a comma.
     *
     * @return queryBy
     **/
    @JsonProperty("query_by")
    public String getQueryBy() {
        return queryBy;
    }

    public void setQueryBy(String queryBy) {
        this.queryBy = queryBy;
    }

    public SearchParameters queryBy(String queryBy) {
        this.queryBy = queryBy;
        return this;
    }

    /**
     * The relative weight to give each &#x60;query_by&#x60; field when ranking results. This can be used to boost fields in priority, when looking for matches. Multiple fields are separated with a comma.
     *
     * @return queryByWeights
     **/
    @JsonProperty("query_by_weights")
    public String getQueryByWeights() {
        return queryByWeights;
    }

    public void setQueryByWeights(String queryByWeights) {
        this.queryByWeights = queryByWeights;
    }

    public SearchParameters queryByWeights(String queryByWeights) {
        this.queryByWeights = queryByWeights;
        return this;
    }

    /**
     * Boolean field to indicate that the last word in the query should be treated as a prefix, and not as a whole word. This is used for building autocomplete and instant search interfaces. Defaults to true.
     *
     * @return prefix
     **/
    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public SearchParameters prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Filter conditions for refining youropen api validator search results. Separate multiple conditions with &amp;&amp;.
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

    public SearchParameters filterBy(String filterBy) {
        this.filterBy = filterBy;
        return this;
    }

    /**
     * A list of numerical fields and their corresponding sort orders that will be used for ordering your results. Up to 3 sort fields can be specified. The text similarity score is exposed as a special &#x60;_text_match&#x60; field that you can use in the list of sorting fields. If no &#x60;sort_by&#x60; parameter is specified, results are sorted by &#x60;_text_match:desc,default_sorting_field:desc&#x60;
     *
     * @return sortBy
     **/
    @JsonProperty("sort_by")
    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public SearchParameters sortBy(String sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    /**
     * A list of fields that will be used for faceting your results on. Separate multiple fields with a comma.
     *
     * @return facetBy
     **/
    @JsonProperty("facet_by")
    public String getFacetBy() {
        return facetBy;
    }

    public void setFacetBy(String facetBy) {
        this.facetBy = facetBy;
    }

    public SearchParameters facetBy(String facetBy) {
        this.facetBy = facetBy;
        return this;
    }

    /**
     * Maximum number of facet values to be returned.
     *
     * @return maxFacetValues
     **/
    @JsonProperty("max_facet_values")
    public Integer getMaxFacetValues() {
        return maxFacetValues;
    }

    public void setMaxFacetValues(Integer maxFacetValues) {
        this.maxFacetValues = maxFacetValues;
    }

    public SearchParameters maxFacetValues(Integer maxFacetValues) {
        this.maxFacetValues = maxFacetValues;
        return this;
    }

    /**
     * Facet values that are returned can now be filtered via this parameter. The matching facet text is also highlighted. For example, when faceting by &#x60;category&#x60;, you can set &#x60;facet_query&#x3D;category:shoe&#x60; to return only facet values that contain the prefix \&quot;shoe\&quot;.
     *
     * @return facetQuery
     **/
    @JsonProperty("facet_query")
    public String getFacetQuery() {
        return facetQuery;
    }

    public void setFacetQuery(String facetQuery) {
        this.facetQuery = facetQuery;
    }

    public SearchParameters facetQuery(String facetQuery) {
        this.facetQuery = facetQuery;
        return this;
    }

    /**
     * The number of typographical errors (1 or 2) that would be tolerated. Default: 2
     *
     * @return numTypos
     **/
    @JsonProperty("num_typos")
    public Integer getNumTypos() {
        return numTypos;
    }

    public void setNumTypos(Integer numTypos) {
        this.numTypos = numTypos;
    }

    public SearchParameters numTypos(Integer numTypos) {
        this.numTypos = numTypos;
        return this;
    }

    /**
     * Results from this specific page number would be fetched.
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

    public SearchParameters page(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Number of results to fetch per page. Default: 10
     *
     * @return perPage
     **/
    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public SearchParameters perPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

    /**
     * You can aggregate search results into groups or buckets by specify one or more &#x60;group_by&#x60; fields. Separate multiple fields with a comma. To group on a particular field, it must be a faceted field.
     *
     * @return groupBy
     **/
    @JsonProperty("group_by")
    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public SearchParameters groupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    /**
     * Maximum number of hits to be returned for every group. If the &#x60;group_limit&#x60; is set as &#x60;K&#x60; then only the top K hits in each group are returned in the response. Default: 3
     *
     * @return groupLimit
     **/
    @JsonProperty("group_limit")
    public Integer getGroupLimit() {
        return groupLimit;
    }

    public void setGroupLimit(Integer groupLimit) {
        this.groupLimit = groupLimit;
    }

    public SearchParameters groupLimit(Integer groupLimit) {
        this.groupLimit = groupLimit;
        return this;
    }

    /**
     * List of fields from the document to include in the search result
     *
     * @return includeFields
     **/
    @JsonProperty("include_fields")
    public String getIncludeFields() {
        return includeFields;
    }

    public void setIncludeFields(String includeFields) {
        this.includeFields = includeFields;
    }

    public SearchParameters includeFields(String includeFields) {
        this.includeFields = includeFields;
        return this;
    }

    /**
     * List of fields from the document to exclude in the search result
     *
     * @return excludeFields
     **/
    @JsonProperty("exclude_fields")
    public String getExcludeFields() {
        return excludeFields;
    }

    public void setExcludeFields(String excludeFields) {
        this.excludeFields = excludeFields;
    }

    public SearchParameters excludeFields(String excludeFields) {
        this.excludeFields = excludeFields;
        return this;
    }

    /**
     * List of fields which should be highlighted fully without snippeting
     *
     * @return highlightFullFields
     **/
    @JsonProperty("highlight_full_fields")
    public String getHighlightFullFields() {
        return highlightFullFields;
    }

    public void setHighlightFullFields(String highlightFullFields) {
        this.highlightFullFields = highlightFullFields;
    }

    public SearchParameters highlightFullFields(String highlightFullFields) {
        this.highlightFullFields = highlightFullFields;
        return this;
    }

    /**
     * The number of tokens that should surround the highlighted text on each side. Default: 4
     *
     * @return highlightAffixNumTokens
     **/
    @JsonProperty("highlight_affix_num_tokens")
    public Integer getHighlightAffixNumTokens() {
        return highlightAffixNumTokens;
    }

    public void setHighlightAffixNumTokens(Integer highlightAffixNumTokens) {
        this.highlightAffixNumTokens = highlightAffixNumTokens;
    }

    public SearchParameters highlightAffixNumTokens(Integer highlightAffixNumTokens) {
        this.highlightAffixNumTokens = highlightAffixNumTokens;
        return this;
    }

    /**
     * The start tag used for the highlighted snippets. Default: &#x60;&lt;mark&gt;&#x60;
     *
     * @return highlightStartTag
     **/
    @JsonProperty("highlight_start_tag")
    public String getHighlightStartTag() {
        return highlightStartTag;
    }

    public void setHighlightStartTag(String highlightStartTag) {
        this.highlightStartTag = highlightStartTag;
    }

    public SearchParameters highlightStartTag(String highlightStartTag) {
        this.highlightStartTag = highlightStartTag;
        return this;
    }

    /**
     * The end tag used for the highlighted snippets. Default: &#x60;&lt;/mark&gt;&#x60;
     *
     * @return highlightEndTag
     **/
    @JsonProperty("highlight_end_tag")
    public String getHighlightEndTag() {
        return highlightEndTag;
    }

    public void setHighlightEndTag(String highlightEndTag) {
        this.highlightEndTag = highlightEndTag;
    }

    public SearchParameters highlightEndTag(String highlightEndTag) {
        this.highlightEndTag = highlightEndTag;
        return this;
    }

    /**
     * Field values under this length will be fully highlighted, instead of showing a snippet of relevant portion. Default: 30
     *
     * @return snippetThreshold
     **/
    @JsonProperty("snippet_threshold")
    public Integer getSnippetThreshold() {
        return snippetThreshold;
    }

    public void setSnippetThreshold(Integer snippetThreshold) {
        this.snippetThreshold = snippetThreshold;
    }

    public SearchParameters snippetThreshold(Integer snippetThreshold) {
        this.snippetThreshold = snippetThreshold;
        return this;
    }

    /**
     * If the number of results found for a specific query is less than this number, Typesense will attempt to drop the tokens in the query until enough results are found. Tokens that have the least individual hits are dropped first. Set to 0 to disable. Default: 10
     *
     * @return dropTokensThreshold
     **/
    @JsonProperty("drop_tokens_threshold")
    public Integer getDropTokensThreshold() {
        return dropTokensThreshold;
    }

    public void setDropTokensThreshold(Integer dropTokensThreshold) {
        this.dropTokensThreshold = dropTokensThreshold;
    }

    public SearchParameters dropTokensThreshold(Integer dropTokensThreshold) {
        this.dropTokensThreshold = dropTokensThreshold;
        return this;
    }

    /**
     * If the number of results found for a specific query is less than this number, Typesense will attempt to look for tokens with more typos until enough results are found. Default: 100
     *
     * @return typoTokensThreshold
     **/
    @JsonProperty("typo_tokens_threshold")
    public Integer getTypoTokensThreshold() {
        return typoTokensThreshold;
    }

    public void setTypoTokensThreshold(Integer typoTokensThreshold) {
        this.typoTokensThreshold = typoTokensThreshold;
    }

    public SearchParameters typoTokensThreshold(Integer typoTokensThreshold) {
        this.typoTokensThreshold = typoTokensThreshold;
        return this;
    }

    /**
     * A list of records to unconditionally include in the search results at specific positions. An example use case would be to feature or promote certain items on the top of search results. A list of &#x60;record_id:hit_position&#x60;. Eg: to include a record with ID 123 at Position 1 and another record with ID 456 at Position 5, you&#x27;d specify &#x60;123:1,456:5&#x60;. You could also use the Overrides feature to override search results based on rules. Overrides are applied first, followed by &#x60;pinned_hits&#x60; and  finally &#x60;hidden_hits&#x60;.
     *
     * @return pinnedHits
     **/
    @JsonProperty("pinned_hits")
    public String getPinnedHits() {
        return pinnedHits;
    }

    public void setPinnedHits(String pinnedHits) {
        this.pinnedHits = pinnedHits;
    }

    public SearchParameters pinnedHits(String pinnedHits) {
        this.pinnedHits = pinnedHits;
        return this;
    }

    /**
     * A list of records to unconditionally hide from search results. A list of &#x60;record_id&#x60;s to hide. Eg: to hide records with IDs 123 and 456, you&#x27;d specify &#x60;123,456&#x60;. You could also use the Overrides feature to override search results based on rules. Overrides are applied first, followed by &#x60;pinned_hits&#x60; and finally &#x60;hidden_hits&#x60;.
     *
     * @return hiddenHits
     **/
    @JsonProperty("hidden_hits")
    public String getHiddenHits() {
        return hiddenHits;
    }

    public void setHiddenHits(String hiddenHits) {
        this.hiddenHits = hiddenHits;
    }

    public SearchParameters hiddenHits(String hiddenHits) {
        this.hiddenHits = hiddenHits;
        return this;
    }

    /**
     * A list of custom fields that must be highlighted even if you don&#x27;t query  for them
     *
     * @return highlightFields
     **/
    @JsonProperty("highlight_fields")
    public String getHighlightFields() {
        return highlightFields;
    }

    public void setHighlightFields(String highlightFields) {
        this.highlightFields = highlightFields;
    }

    public SearchParameters highlightFields(String highlightFields) {
        this.highlightFields = highlightFields;
        return this;
    }

    /**
     * You can index content from any logographic language into Typesense if you are able to segment / split the text into space-separated words yourself  before indexing and querying. Set this parameter to true to do the same
     *
     * @return preSegmentedQuery
     **/
    @JsonProperty("pre_segmented_query")
    public Boolean isPreSegmentedQuery() {
        return preSegmentedQuery;
    }

    public void setPreSegmentedQuery(Boolean preSegmentedQuery) {
        this.preSegmentedQuery = preSegmentedQuery;
    }

    public SearchParameters preSegmentedQuery(Boolean preSegmentedQuery) {
        this.preSegmentedQuery = preSegmentedQuery;
        return this;
    }

    /**
     * If you have some overrides defined but want to disable all of them during query time, you can do that by setting this parameter to false
     *
     * @return enableOverrides
     **/
    @JsonProperty("enable_overrides")
    public Boolean isEnableOverrides() {
        return enableOverrides;
    }

    public void setEnableOverrides(Boolean enableOverrides) {
        this.enableOverrides = enableOverrides;
    }

    public SearchParameters enableOverrides(Boolean enableOverrides) {
        this.enableOverrides = enableOverrides;
        return this;
    }

    /**
     * Set this parameter to true to ensure that an exact match is ranked above the others
     *
     * @return prioritizeExactMatch
     **/
    @JsonProperty("prioritize_exact_match")
    public Boolean isPrioritizeExactMatch() {
        return prioritizeExactMatch;
    }

    public void setPrioritizeExactMatch(Boolean prioritizeExactMatch) {
        this.prioritizeExactMatch = prioritizeExactMatch;
    }

    public SearchParameters prioritizeExactMatch(Boolean prioritizeExactMatch) {
        this.prioritizeExactMatch = prioritizeExactMatch;
        return this;
    }

    /**
     * Setting this to true will make Typesense consider all prefixes and typo  corrections of the words in the query without stopping early when enough results are found  (drop_tokens_threshold and typo_tokens_threshold configurations are ignored).
     *
     * @return exhaustiveSearch
     **/
    @JsonProperty("exhaustive_search")
    public Boolean isExhaustiveSearch() {
        return exhaustiveSearch;
    }

    public void setExhaustiveSearch(Boolean exhaustiveSearch) {
        this.exhaustiveSearch = exhaustiveSearch;
    }

    public SearchParameters exhaustiveSearch(Boolean exhaustiveSearch) {
        this.exhaustiveSearch = exhaustiveSearch;
        return this;
    }

    /**
     * Typesense will attempt to return results early if the cutoff time has elapsed.  This is not a strict guarantee and facet computation is not bound by this parameter.
     *
     * @return searchCutoffMs
     **/
    @JsonProperty("search_cutoff_ms")
    public Integer getSearchCutoffMs() {
        return searchCutoffMs;
    }

    public void setSearchCutoffMs(Integer searchCutoffMs) {
        this.searchCutoffMs = searchCutoffMs;
    }

    public SearchParameters searchCutoffMs(Integer searchCutoffMs) {
        this.searchCutoffMs = searchCutoffMs;
        return this;
    }

    /**
     * Enable server side caching of search query results. By default, caching is disabled.
     *
     * @return useCache
     **/
    @JsonProperty("use_cache")
    public Boolean isUseCache() {
        return useCache;
    }

    public void setUseCache(Boolean useCache) {
        this.useCache = useCache;
    }

    public SearchParameters useCache(Boolean useCache) {
        this.useCache = useCache;
        return this;
    }

    /**
     * The duration (in seconds) that determines how long the search query is cached.  This value can be set on a per-query basis. Default: 60.
     *
     * @return cacheTtl
     **/
    @JsonProperty("cache_ttl")
    public Integer getCacheTtl() {
        return cacheTtl;
    }

    public void setCacheTtl(Integer cacheTtl) {
        this.cacheTtl = cacheTtl;
    }

    public SearchParameters cacheTtl(Integer cacheTtl) {
        this.cacheTtl = cacheTtl;
        return this;
    }

    /**
     * Minimum word length for 1-typo correction to be applied.  The value of num_typos is still treated as the maximum allowed typos.
     *
     * @return minLen1typo
     **/
    @JsonProperty("min_len_1typo")
    public Integer getMinLen1typo() {
        return minLen1typo;
    }

    public void setMinLen1typo(Integer minLen1typo) {
        this.minLen1typo = minLen1typo;
    }

    public SearchParameters minLen1typo(Integer minLen1typo) {
        this.minLen1typo = minLen1typo;
        return this;
    }

    /**
     * Minimum word length for 2-typo correction to be applied.  The value of num_typos is still treated as the maximum allowed typos.
     *
     * @return minLen2typo
     **/
    @JsonProperty("min_len_2typo")
    public Integer getMinLen2typo() {
        return minLen2typo;
    }

    public void setMinLen2typo(Integer minLen2typo) {
        this.minLen2typo = minLen2typo;
    }

    public SearchParameters minLen2typo(Integer minLen2typo) {
        this.minLen2typo = minLen2typo;
        return this;
    }


    @Override
    public String toString() {

        return "class SearchParameters {\n" +
                "    q: " + toIndentedString(q) + '\n' +
                "    queryBy: " + toIndentedString(queryBy) + '\n' +
                "    queryByWeights: " + toIndentedString(queryByWeights) + '\n' +
                "    prefix: " + toIndentedString(prefix) + '\n' +
                "    filterBy: " + toIndentedString(filterBy) + '\n' +
                "    sortBy: " + toIndentedString(sortBy) + '\n' +
                "    facetBy: " + toIndentedString(facetBy) + '\n' +
                "    maxFacetValues: " + toIndentedString(maxFacetValues) + '\n' +
                "    facetQuery: " + toIndentedString(facetQuery) + '\n' +
                "    numTypos: " + toIndentedString(numTypos) + '\n' +
                "    page: " + toIndentedString(page) + '\n' +
                "    perPage: " + toIndentedString(perPage) + '\n' +
                "    groupBy: " + toIndentedString(groupBy) + '\n' +
                "    groupLimit: " + toIndentedString(groupLimit) + '\n' +
                "    includeFields: " + toIndentedString(includeFields) + '\n' +
                "    excludeFields: " + toIndentedString(excludeFields) + '\n' +
                "    highlightFullFields: " + toIndentedString(highlightFullFields) + '\n' +
                "    highlightAffixNumTokens: " + toIndentedString(highlightAffixNumTokens) + '\n' +
                "    highlightStartTag: " + toIndentedString(highlightStartTag) + '\n' +
                "    highlightEndTag: " + toIndentedString(highlightEndTag) + '\n' +
                "    snippetThreshold: " + toIndentedString(snippetThreshold) + '\n' +
                "    dropTokensThreshold: " + toIndentedString(dropTokensThreshold) + '\n' +
                "    typoTokensThreshold: " + toIndentedString(typoTokensThreshold) + '\n' +
                "    pinnedHits: " + toIndentedString(pinnedHits) + '\n' +
                "    hiddenHits: " + toIndentedString(hiddenHits) + '\n' +
                "    highlightFields: " + toIndentedString(highlightFields) + '\n' +
                "    preSegmentedQuery: " + toIndentedString(preSegmentedQuery) + '\n' +
                "    enableOverrides: " + toIndentedString(enableOverrides) + '\n' +
                "    prioritizeExactMatch: " + toIndentedString(prioritizeExactMatch) + '\n' +
                "    exhaustiveSearch: " + toIndentedString(exhaustiveSearch) + '\n' +
                "    searchCutoffMs: " + toIndentedString(searchCutoffMs) + '\n' +
                "    useCache: " + toIndentedString(useCache) + '\n' +
                "    cacheTtl: " + toIndentedString(cacheTtl) + '\n' +
                "    minLen1typo: " + toIndentedString(minLen1typo) + '\n' +
                "    minLen2typo: " + toIndentedString(minLen2typo) + '\n' +
                '}';
    }

}
