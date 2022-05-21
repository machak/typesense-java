package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class MultiSearchSearchesParameter extends BaseModel {

    @Schema(required = true)
    private List<MultiSearchCollectionParameters> searches = new ArrayList<MultiSearchCollectionParameters>();

    /**
     * Get searches
     *
     * @return searches
     **/
    @JsonProperty("searches")
    public List<MultiSearchCollectionParameters> getSearches() {
        return searches;
    }

    public void setSearches(List<MultiSearchCollectionParameters> searches) {
        this.searches = searches;
    }

    public MultiSearchSearchesParameter searches(List<MultiSearchCollectionParameters> searches) {
        this.searches = searches;
        return this;
    }

    public MultiSearchSearchesParameter addSearchesItem(MultiSearchCollectionParameters searchesItem) {
        this.searches.add(searchesItem);
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MultiSearchSearchesParameter {\n");

        sb.append("    searches: ").append(toIndentedString(searches)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}
