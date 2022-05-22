package org.typesense.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class ScopedKeyParameters extends BaseModel {

    @Schema()
    private String filterBy = null;

    @Schema()
    private BigDecimal expiresAt = null;

    /**
     * Get filterBy
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

    public ScopedKeyParameters filterBy(String filterBy) {
        this.filterBy = filterBy;
        return this;
    }

    /**
     * Get expiresAt
     *
     * @return expiresAt
     **/
    @JsonProperty("expires_at")
    public BigDecimal getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(BigDecimal expiresAt) {
        this.expiresAt = expiresAt;
    }

    public ScopedKeyParameters expiresAt(BigDecimal expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }


    @Override
    public String toString() {

        return "class ScopedKeyParameters {\n" +
                "    filterBy: " + toIndentedString(filterBy) + '\n' +
                "    expiresAt: " + toIndentedString(expiresAt) + '\n' +
                '}';
    }


}
