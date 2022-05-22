package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class CollectionSchema extends BaseModel {

    @Schema(example = "companies", required = true, description = "Name of the collection")
    /**
     * Name of the collection
     **/
    private String name = null;

    @Schema(example = "[{\"name\":\"company_name\",\"type\":\"string\",\"facet\":false},{\"name\":\"num_employees\",\"type\":\"int32\",\"facet\":false},{\"name\":\"country\",\"type\":\"string\",\"facet\":true}]", required = true, description = "A list of fields for querying, filtering and faceting")
    /**
     * A list of fields for querying, filtering and faceting
     **/
    private List<Field> fields = new ArrayList<Field>();

    @Schema(example = "num_employees", description = "The name of an int32 / float field that determines the order in which the search results are ranked when a sort_by clause is not provided during searching. This field must indicate some kind of popularity.")
    /**
     * The name of an int32 / float field that determines the order in which the search results are ranked when a sort_by clause is not provided during searching. This field must indicate some kind of popularity.
     **/
    private String defaultSortingField = "";

    @Schema(description = "List of symbols or special characters to be used for  splitting the text into individual words in addition to space and new-line characters. ")
    /**
     * List of symbols or special characters to be used for  splitting the text into individual words in addition to space and new-line characters.
     **/
    private List<String> tokenSeparators = null;

    @Schema(description = "List of symbols or special characters to be indexed. ")
    /**
     * List of symbols or special characters to be indexed.
     **/
    private List<String> symbolsToIndex = null;

    /**
     * Name of the collection
     *
     * @return name
     **/
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CollectionSchema name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A list of fields for querying, filtering and faceting
     *
     * @return fields
     **/
    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public CollectionSchema fields(List<Field> fields) {
        this.fields = fields;
        return this;
    }

    public CollectionSchema addFieldsItem(Field fieldsItem) {
        this.fields.add(fieldsItem);
        return this;
    }

    /**
     * The name of an int32 / float field that determines the order in which the search results are ranked when a sort_by clause is not provided during searching. This field must indicate some kind of popularity.
     *
     * @return defaultSortingField
     **/
    @JsonProperty("default_sorting_field")
    public String getDefaultSortingField() {
        return defaultSortingField;
    }

    public void setDefaultSortingField(String defaultSortingField) {
        this.defaultSortingField = defaultSortingField;
    }

    public CollectionSchema defaultSortingField(String defaultSortingField) {
        this.defaultSortingField = defaultSortingField;
        return this;
    }

    /**
     * List of symbols or special characters to be used for  splitting the text into individual words in addition to space and new-line characters.
     *
     * @return tokenSeparators
     **/
    @JsonProperty("token_separators")
    public List<String> getTokenSeparators() {
        return tokenSeparators;
    }

    public void setTokenSeparators(List<String> tokenSeparators) {
        this.tokenSeparators = tokenSeparators;
    }

    public CollectionSchema tokenSeparators(List<String> tokenSeparators) {
        this.tokenSeparators = tokenSeparators;
        return this;
    }

    public CollectionSchema addTokenSeparatorsItem(String tokenSeparatorsItem) {
        this.tokenSeparators.add(tokenSeparatorsItem);
        return this;
    }

    /**
     * List of symbols or special characters to be indexed.
     *
     * @return symbolsToIndex
     **/
    @JsonProperty("symbols_to_index")
    public List<String> getSymbolsToIndex() {
        return symbolsToIndex;
    }

    public void setSymbolsToIndex(List<String> symbolsToIndex) {
        this.symbolsToIndex = symbolsToIndex;
    }

    public CollectionSchema symbolsToIndex(List<String> symbolsToIndex) {
        this.symbolsToIndex = symbolsToIndex;
        return this;
    }

    public CollectionSchema addSymbolsToIndexItem(String symbolsToIndexItem) {
        this.symbolsToIndex.add(symbolsToIndexItem);
        return this;
    }


    @Override
    public String toString() {

        return "class CollectionSchema {\n" +
                "    name: " + toIndentedString(name) + '\n' +
                "    fields: " + toIndentedString(fields) + '\n' +
                "    defaultSortingField: " + toIndentedString(defaultSortingField) + '\n' +
                "    tokenSeparators: " + toIndentedString(tokenSeparators) + '\n' +
                "    symbolsToIndex: " + toIndentedString(symbolsToIndex) + '\n' +
                '}';
    }


}
