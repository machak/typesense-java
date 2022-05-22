package org.typesense.api;

import java.util.ArrayList;
import java.util.Map;

import org.typesense.api.exceptions.HttpError;
import org.typesense.api.exceptions.ObjectAlreadyExists;
import org.typesense.api.exceptions.ObjectNotFound;
import org.typesense.api.exceptions.ObjectUnprocessable;
import org.typesense.api.exceptions.RequestForbidden;
import org.typesense.api.exceptions.RequestMalformed;
import org.typesense.api.exceptions.RequestUnauthorized;
import org.typesense.api.exceptions.ServerError;
import org.typesense.api.exceptions.ServiceUnavailable;
import org.typesense.api.exceptions.TypesenseError;
import org.typesense.model.ErrorResponse;

import jakarta.ws.rs.core.Response;

public abstract class BaseCall implements TypesenseCall {
    protected TypesenseError getException(Response response) {
        final ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
        final String message = errorResponse.getMessage();
        final int status_code = response.getStatus();

        if (status_code == 400) {
            return new RequestMalformed(message, status_code);
        } else if (status_code == 401) {
            return new RequestUnauthorized(message, status_code);
        } else if (status_code == 403) {
            return new RequestForbidden(message, status_code);
        } else if (status_code == 404) {
            return new ObjectNotFound(message, status_code);
        } else if (status_code == 409) {
            return new ObjectAlreadyExists(message, status_code);
        } else if (status_code == 422) {
            return new ObjectUnprocessable(message, status_code);
        } else if (status_code == 500) {
            return new ServerError(message, status_code);
        } else if (status_code == 503) {
            return new ServiceUnavailable(message, status_code);
        } else {
            return new HttpError(message, status_code);
        }
    }

    protected void extractParameters(final Map.Entry<String, Object> entry, final StringBuilder value) {
        for (int i = 0; i < ((ArrayList<?>) entry.getValue()).size(); i++) {
            value.append(((ArrayList<?>) entry.getValue()).get(i));
            if (i != ((ArrayList<?>) entry.getValue()).size() - 1) {
                value.append(',');
            }
        }
    }
}
