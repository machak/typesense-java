package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class SuccessStatus extends BaseModel {

    @Schema(required = true)
    private Boolean success = null;

    /**
     * Get success
     *
     * @return success
     **/
    @JsonProperty("success")
    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public SuccessStatus success(Boolean success) {
        this.success = success;
        return this;
    }


    @Override
    public String toString() {

        return "class SuccessStatus {\n" +
                "    success: " + toIndentedString(success) + '\n' +
                '}';
    }

}
