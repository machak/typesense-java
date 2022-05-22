package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchOverrideRule extends BaseModel {

    @Schema(required = true, description = "Indicates what search queries should be overridden")
    /**
     * Indicates what search queries should be overridden
     **/
    private String query = null;

    public enum MatchEnum {
        EXACT("exact"),
        CONTAINS("contains");

        private final String value;

        MatchEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static MatchEnum fromValue(String text) {
            for (MatchEnum b : MatchEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @Schema(required = true, description = "Indicates whether the match on the query term should be `exact` or `contains`. If we want to match all queries that contained the word `apple`, we will use the `contains` match instead. ")
    /**
     * Indicates whether the match on the query term should be `exact` or `contains`. If we want to match all queries that contained the word `apple`, we will use the `contains` match instead.
     **/
    private MatchEnum match = null;

    /**
     * Indicates what search queries should be overridden
     *
     * @return query
     **/
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public SearchOverrideRule query(String query) {
        this.query = query;
        return this;
    }

    /**
     * Indicates whether the match on the query term should be &#x60;exact&#x60; or &#x60;contains&#x60;. If we want to match all queries that contained the word &#x60;apple&#x60;, we will use the &#x60;contains&#x60; match instead.
     *
     * @return match
     **/
    @JsonProperty("match")
    public String getMatch() {
        if (match == null) {
            return null;
        }
        return match.getValue();
    }

    public void setMatch(MatchEnum match) {
        this.match = match;
    }

    public SearchOverrideRule match(MatchEnum match) {
        this.match = match;
        return this;
    }


    @Override
    public String toString() {

        return "class SearchOverrideRule {\n" +
                "    query: " + toIndentedString(query) + '\n' +
                "    match: " + toIndentedString(match) + '\n' +
                '}';
    }

}
