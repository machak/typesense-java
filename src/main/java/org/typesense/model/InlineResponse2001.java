package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class InlineResponse2001 extends BaseModel {

    @Schema()
    private String version = null;

    /**
     * Get version
     *
     * @return version
     **/
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public InlineResponse2001 version(String version) {
        this.version = version;
        return this;
    }


    @Override
    public String toString() {

        return "class InlineResponse2001 {\n" +
                "    version: " + toIndentedString(version) + '\n' +
                '}';
    }


}
