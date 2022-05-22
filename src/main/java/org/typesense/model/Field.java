package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class Field extends BaseModel {

    @Schema(example = "company_name", required = true)
    private String name = null;

    @Schema(example = "string", required = true)
    private String type = null;

    @Schema(example = "true")
    private Boolean optional = false;

    @Schema(example = "false")
    private Boolean facet = false;

    @Schema(example = "true")
    private Boolean index = true;

    @Schema(example = "el")
    private String locale = null;

    @Schema(example = "true")
    private Boolean sort = false;

    @Schema(example = "true")
    private Boolean infix = false;

    @Schema(example = "true")
    private Boolean drop = null;

    /**
     * Get name
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

    public Field name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Field type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get optional
     *
     * @return optional
     **/
    @JsonProperty("optional")
    public Boolean isOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    public Field optional(Boolean optional) {
        this.optional = optional;
        return this;
    }

    /**
     * Get facet
     *
     * @return facet
     **/
    @JsonProperty("facet")
    public Boolean isFacet() {
        return facet;
    }

    public void setFacet(Boolean facet) {
        this.facet = facet;
    }

    public Field facet(Boolean facet) {
        this.facet = facet;
        return this;
    }

    /**
     * Get index
     *
     * @return index
     **/
    @JsonProperty("index")
    public Boolean isIndex() {
        return index;
    }

    public void setIndex(Boolean index) {
        this.index = index;
    }

    public Field index(Boolean index) {
        this.index = index;
        return this;
    }

    /**
     * Get locale
     *
     * @return locale
     **/
    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Field locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * Get sort
     *
     * @return sort
     **/
    @JsonProperty("sort")
    public Boolean isSort() {
        return sort;
    }

    public void setSort(Boolean sort) {
        this.sort = sort;
    }

    public Field sort(Boolean sort) {
        this.sort = sort;
        return this;
    }

    /**
     * Get infix
     *
     * @return infix
     **/
    @JsonProperty("infix")
    public Boolean isInfix() {
        return infix;
    }

    public void setInfix(Boolean infix) {
        this.infix = infix;
    }

    public Field infix(Boolean infix) {
        this.infix = infix;
        return this;
    }

    /**
     * Get drop
     *
     * @return drop
     **/
    @JsonProperty("drop")
    public Boolean isDrop() {
        return drop;
    }

    public void setDrop(Boolean drop) {
        this.drop = drop;
    }

    public Field drop(Boolean drop) {
        this.drop = drop;
        return this;
    }


    @Override
    public String toString() {

        return "class Field {\n" +
                "    name: " + toIndentedString(name) + '\n' +
                "    type: " + toIndentedString(type) + '\n' +
                "    optional: " + toIndentedString(optional) + '\n' +
                "    facet: " + toIndentedString(facet) + '\n' +
                "    index: " + toIndentedString(index) + '\n' +
                "    locale: " + toIndentedString(locale) + '\n' +
                "    sort: " + toIndentedString(sort) + '\n' +
                "    infix: " + toIndentedString(infix) + '\n' +
                "    drop: " + toIndentedString(drop) + '\n' +
                '}';
    }


}
