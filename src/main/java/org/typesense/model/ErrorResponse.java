package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponse extends BaseModel {

    @Schema()
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

    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }


    @Override
    public String toString() {

        final String sb = "class ErrorResponse {\n" +
                "    message: " + toIndentedString(message) + '\n' +
                '}';
        return sb;
    }

}
