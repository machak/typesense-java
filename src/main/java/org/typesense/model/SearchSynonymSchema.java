package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchSynonymSchema extends BaseModel {

    @Schema(description = "For 1-way synonyms, indicates the root word that words in the `synonyms` parameter map to.")
    /**
     * For 1-way synonyms, indicates the root word that words in the `synonyms` parameter map to.
     **/
    private String root = null;

    @Schema(required = true, description = "Array of words that should be considered as synonyms.")
    /**
     * Array of words that should be considered as synonyms.
     **/
    private List<String> synonyms = new ArrayList<String>();

    /**
     * For 1-way synonyms, indicates the root word that words in the &#x60;synonyms&#x60; parameter map to.
     *
     * @return root
     **/
    @JsonProperty("root")
    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public SearchSynonymSchema root(String root) {
        this.root = root;
        return this;
    }

    /**
     * Array of words that should be considered as synonyms.
     *
     * @return synonyms
     **/
    @JsonProperty("synonyms")
    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public SearchSynonymSchema synonyms(List<String> synonyms) {
        this.synonyms = synonyms;
        return this;
    }

    public SearchSynonymSchema addSynonymsItem(String synonymsItem) {
        this.synonyms.add(synonymsItem);
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class SearchSynonymSchema {\n" +
                "    root: " + toIndentedString(root) + '\n' +
                "    synonyms: " + toIndentedString(synonyms) + '\n' +
                '}';
        return sb;
    }


}
