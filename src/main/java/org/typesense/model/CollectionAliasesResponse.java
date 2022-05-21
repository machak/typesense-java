package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class CollectionAliasesResponse extends BaseModel {

    @Schema(required = true)
    private List<CollectionAlias> aliases = new ArrayList<CollectionAlias>();

    /**
     * Get aliases
     *
     * @return aliases
     **/
    @JsonProperty("aliases")
    public List<CollectionAlias> getAliases() {
        return aliases;
    }

    public void setAliases(List<CollectionAlias> aliases) {
        this.aliases = aliases;
    }

    public CollectionAliasesResponse aliases(List<CollectionAlias> aliases) {
        this.aliases = aliases;
        return this;
    }

    public CollectionAliasesResponse addAliasesItem(CollectionAlias aliasesItem) {
        this.aliases.add(aliasesItem);
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CollectionAliasesResponse {\n");

        sb.append("    aliases: ").append(toIndentedString(aliases)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
