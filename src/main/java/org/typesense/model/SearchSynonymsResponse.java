package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchSynonymsResponse extends BaseModel {

  @Schema(required = true)
  private List<SearchSynonym> synonyms = new ArrayList<SearchSynonym>();
 /**
   * Get synonyms
   * @return synonyms
  **/
  @JsonProperty("synonyms")
  public List<SearchSynonym> getSynonyms() {
    return synonyms;
  }

  public void setSynonyms(List<SearchSynonym> synonyms) {
    this.synonyms = synonyms;
  }

  public SearchSynonymsResponse synonyms(List<SearchSynonym> synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  public SearchSynonymsResponse addSynonymsItem(SearchSynonym synonymsItem) {
    this.synonyms.add(synonymsItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchSynonymsResponse {\n");

    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
