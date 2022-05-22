package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchResultRequestParams extends BaseModel {

    @Schema(required = true)
    private String collectionName = null;

    @Schema(required = true)
    private String q = null;

    @Schema(required = true)
    private Integer perPage = null;

    /**
     * Get collectionName
     *
     * @return collectionName
     **/
    @JsonProperty("collection_name")
    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public SearchResultRequestParams collectionName(String collectionName) {
        this.collectionName = collectionName;
        return this;
    }

    /**
     * Get q
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

    public SearchResultRequestParams q(String q) {
        this.q = q;
        return this;
    }

    /**
     * Get perPage
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

    public SearchResultRequestParams perPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class SearchResultRequestParams {\n" +
                "    collectionName: " + toIndentedString(collectionName) + '\n' +
                "    q: " + toIndentedString(q) + '\n' +
                "    perPage: " + toIndentedString(perPage) + '\n' +
                '}';
        return sb;
    }

}
