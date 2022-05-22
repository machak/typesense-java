package org.typesense.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class HealthStatus extends BaseModel {

    @Schema(required = true)
    private Boolean ok = null;

    /**
     * Get ok
     *
     * @return ok
     **/
    @JsonProperty("ok")
    public Boolean isOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public HealthStatus ok(Boolean ok) {
        this.ok = ok;
        return this;
    }


    @Override
    public String toString() {

        return "class HealthStatus {\n" +
                "    ok: " + toIndentedString(ok) + '\n' +
                '}';
    }

}
