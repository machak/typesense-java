package org.typesense.api;

import java.util.Map;

public class Metrics {

    private final TypesenseCall apiCall;
    public static final String RESOURCEPATH = "/metrics.json";

    public Metrics(final TypesenseCall apiCall) {
        this.apiCall = apiCall;
    }

    public Map<String, String> retrieve() throws Exception {
        return this.apiCall.get(RESOURCEPATH);
    }
}
