package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchGroupedHit extends BaseModel {

    @Schema(required = true)
    private List<String> groupKey = new ArrayList<String>();

    @Schema(required = true, description = "The documents that matched the search query")
    /**
     * The documents that matched the search query
     **/
    private List<SearchResultHit> hits = new ArrayList<SearchResultHit>();

    /**
     * Get groupKey
     *
     * @return groupKey
     **/
    @JsonProperty("group_key")
    public List<String> getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(List<String> groupKey) {
        this.groupKey = groupKey;
    }

    public SearchGroupedHit groupKey(List<String> groupKey) {
        this.groupKey = groupKey;
        return this;
    }

    public SearchGroupedHit addGroupKeyItem(String groupKeyItem) {
        this.groupKey.add(groupKeyItem);
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

    public SearchGroupedHit hits(List<SearchResultHit> hits) {
        this.hits = hits;
        return this;
    }

    public SearchGroupedHit addHitsItem(SearchResultHit hitsItem) {
        this.hits.add(hitsItem);
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SearchGroupedHit {\n");

        sb.append("    groupKey: ").append(toIndentedString(groupKey)).append("\n");
        sb.append("    hits: ").append(toIndentedString(hits)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
