package org.typesense.api;

import java.util.HashMap;

public class Metrics {

    private final Call apiCall;
    public static final String RESOURCEPATH = "/metrics.json";

    public Metrics(final Call apiCall) {
        this.apiCall = apiCall;
    }

    public HashMap<String, String> retrieve() throws Exception {
        return this.apiCall.get(RESOURCEPATH);
    }
}
