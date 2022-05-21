package org.typesense.model;

import java.util.List;
import org.typesense.model.ApiKeySchema;

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

public class ApiKey extends ApiKeySchema  {

  @Schema(required = true)
  private final Long id = null;

  @Schema(required = true)
  private final String value = null;

  @Schema(required = true)
  private final String valuePrefix = null;
 /**
   * Get id
   * @return id
  **/
  @JsonProperty("id")
  public Long getId() {
    return id;
  }


 /**
   * Get value
   * @return value
  **/
  @JsonProperty("value")
  public String getValue() {
    return value;
  }


 /**
   * Get valuePrefix
   * @return valuePrefix
  **/
  @JsonProperty("value_prefix")
  public String getValuePrefix() {
    return valuePrefix;
  }



  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiKey {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valuePrefix: ").append(toIndentedString(valuePrefix)).append("\n");
    sb.append("}");
    return sb.toString();
  }

}
