package org.typesense.api;

import java.util.HashMap;

public class Metrics {

    private final TypesenseCall apiCall;
    public static final String RESOURCEPATH = "/metrics.json";

    public Metrics(final TypesenseCall apiCall) {
        this.apiCall = apiCall;
    }

    public HashMap<String, String> retrieve() throws Exception {
        return this.apiCall.get(RESOURCEPATH);
    }
}
