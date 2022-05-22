package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SearchOverridesResponse extends BaseModel {

    @Schema(required = true)
    private List<SearchOverride> overrides = new ArrayList<SearchOverride>();

    /**
     * Get overrides
     *
     * @return overrides
     **/
    @JsonProperty("overrides")
    public List<SearchOverride> getOverrides() {
        return overrides;
    }

    public void setOverrides(List<SearchOverride> overrides) {
        this.overrides = overrides;
    }

    public SearchOverridesResponse overrides(List<SearchOverride> overrides) {
        this.overrides = overrides;
        return this;
    }

    public SearchOverridesResponse addOverridesItem(SearchOverride overridesItem) {
        this.overrides.add(overridesItem);
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class SearchOverridesResponse {\n" +
                "    overrides: " + toIndentedString(overrides) + '\n' +
                '}';
        return sb;
    }

}
