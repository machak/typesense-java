package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class ModelApiResponse extends BaseModel {

    @Schema(required = true)
    private String message = null;

    /**
     * Get message
     *
     * @return message
     **/
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ModelApiResponse message(String message) {
        this.message = message;
        return this;
    }


    @Override
    public String toString() {

        return "class ModelApiResponse {\n" +
                "    message: " + toIndentedString(message) + '\n' +
                '}';
    }

}
