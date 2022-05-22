package org.typesense.api.exceptions;

public class TypesenseError extends Exception {
    public final String message;
    public final int status;

    public TypesenseError(String message, int status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ':' + '\n' + "Request failed with status code: " + this.status + ".Server said: " + this.message;
    }
}
