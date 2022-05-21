package org.typesense.api;

import java.util.Map;

public class Debug {

    private final Call apiCall;
    public static final String RESOURCEPATH = "/debug";

    public Debug(final Call apiCall) {
        this.apiCall = apiCall;
    }

    public Map<String, String> retrieve() throws Exception {
        return this.apiCall.get(RESOURCEPATH);
    }
}
