package org.typesense.model;

import java.util.ArrayList;
import java.util.List;
import org.typesense.model.CollectionAlias;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CollectionAliasesResponse   {

  @Schema(required = true)
  private List<CollectionAlias> aliases = new ArrayList<CollectionAlias>();
 /**
   * Get aliases
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

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
