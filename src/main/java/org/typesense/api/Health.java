package org.typesense.api;

import java.util.HashMap;

public class Health {

    private final TypesenseCall apiCall;
    public static final String RESOURCEPATH = "/health";

    public Health(final TypesenseCall apiCall) {
        this.apiCall = apiCall;
    }

    public HashMap<String, Object> retrieve() throws Exception {
        return this.apiCall.get(RESOURCEPATH);
    }
}
