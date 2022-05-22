package org.typesense.api;

import java.util.Map;

public class Debug {

    private final TypesenseCall apiCall;
    public static final String RESOURCEPATH = "/debug";

    public Debug(final TypesenseCall apiCall) {
        this.apiCall = apiCall;
    }

    public Map<String, String> retrieve() throws Exception {
        return this.apiCall.get(RESOURCEPATH);
    }
}
