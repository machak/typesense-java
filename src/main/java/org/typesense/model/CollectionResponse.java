package org.typesense.model;

import java.util.List;
import org.typesense.model.CollectionSchema;
import org.typesense.model.Field;

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

public class CollectionResponse extends CollectionSchema  {

  @Schema(required = true, description = "Number of documents in the collection")
 /**
   * Number of documents in the collection
  **/
  private final Long numDocuments = null;

  @Schema(required = true, description = "Timestamp of when the collection was created")
 /**
   * Timestamp of when the collection was created
  **/
  private final Long createdAt = null;
 /**
   * Number of documents in the collection
   * @return numDocuments
  **/
  @JsonProperty("num_documents")
  public Long getNumDocuments() {
    return numDocuments;
  }


 /**
   * Timestamp of when the collection was created
   * @return createdAt
  **/
  @JsonProperty("created_at")
  public Long getCreatedAt() {
    return createdAt;
  }



  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollectionResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    numDocuments: ").append(toIndentedString(numDocuments)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
