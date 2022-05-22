package org.typesense.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class CollectionUpdateSchema extends BaseModel {

    @Schema(example = "[{\"name\":\"company_name\",\"type\":\"string\",\"facet\":false},{\"name\":\"num_employees\",\"type\":\"int32\",\"facet\":false},{\"name\":\"country\",\"type\":\"string\",\"facet\":true}]", required = true, description = "A list of fields for querying, filtering and faceting")
    /**
     * A list of fields for querying, filtering and faceting
     **/
    private List<Field> fields = new ArrayList<Field>();

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

    public CollectionUpdateSchema fields(List<Field> fields) {
        this.fields = fields;
        return this;
    }

    public CollectionUpdateSchema addFieldsItem(Field fieldsItem) {
        this.fields.add(fieldsItem);
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class CollectionUpdateSchema {\n" +
                "    fields: " + toIndentedString(fields) + '\n' +
                '}';
        return sb;
    }


}
